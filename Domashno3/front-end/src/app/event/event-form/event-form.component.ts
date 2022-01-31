import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/auth/auth.service';
import { EventService } from '../event.service';
import { Location } from '../IEvent';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})
export class EventFormComponent implements OnInit {

  sendImage?:any;

   sub!:Subscription;
  errorMessage: string = '';
  newEvent: boolean = true;

  eventForm: FormGroup =  new FormGroup({
    isOnline: new FormControl(false),
    name: new FormControl('',),
    base64image: new FormControl(''),
    description: new FormControl(''),
    contact: new FormGroup({
      contactName: new FormControl(null),
      phoneNumber: new FormControl(null),
      email: new FormControl(null)
    }),
    category: new FormControl(''),
    location: new FormGroup({
      locationName: new FormControl(''),
      address: new FormGroup({
        country: new FormControl(''),
        city: new FormControl(''),
        road: new FormControl('')
      }),
      latitude: new FormControl(''),
      longitude: new FormControl(''),
      link: new FormControl('')
    }),
  })

  constructor(private route: ActivatedRoute,
                private eventService: EventService,
                private router: Router,
                public authService: AuthService,){}

  ngOnDestroy(): void {
    if(this.sub){
      this.sub.unsubscribe();
    }
  }

  ngOnInit(): void {
    const path =  this.route.snapshot.url;
    if(path.length===3){
      this.newEvent = false;
      this.sub = this.eventService.getEvent(Number(path[2])).subscribe({
        next: event => this.eventForm?.setValue({
          name: event.name,
          base64image: event?.base64image,
          description: event.description,
          contactName: event.contact?.contactName,
          phoneNumber: event.contact?.phoneNumber,
          email: event.contact?.email,
          category: event.category?.valueOf(),
        }),
        error: err => this.errorMessage = err
      });
    }else{
      this.newEvent = true;
    }
    console.log(this.eventForm?.value);
  }

  onlineCheck(){
    this.eventForm.patchValue({
      isOnline: !this.eventForm.get('isOnline')?.value
    })
  }

  saveImage(base64image:any){
    this.eventForm.patchValue({
      base64image: base64image
    })
  }

  onAddressChange(event: Location) {
    this.eventForm.patchValue({
      location: {
        address:{
          city: event.address.city?.toString(),
          country: event.address.country?.toString(),
          road: event.address.road?.toString()
        },
        point: {
          latitude: event.lat,
          longitude: event.lon
        }
      }
    })
    console.log(this.eventForm.value)
  }

  onSubmit(eventForm: FormGroup){

    this.eventService.addEvent({
      createBy: this.authService.getCurrentUser().userId,
      isOnline: eventForm?.get('isOnline')?.value,
      name: eventForm?.get('name')?.value,
      base64image: eventForm?.get('base64image')?.value,
      description: eventForm?.get('description')?.value,
      contact: eventForm?.get('contact')?.value,
      category: eventForm?.get('category')?.value,
      location: eventForm?.get('location')?.value
    });
    this.router.navigate(["/events"]);
  }

  cancel(){
    this.router.navigate(['/events']);
  }
}
