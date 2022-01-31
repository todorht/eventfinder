import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscriber, Subscription } from 'rxjs';
import { EventService } from '../event.service';
import { IEvent } from '../IEvent';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.scss']
})
export class EventDetailsComponent implements OnInit, OnDestroy {

  event!: IEvent;
  eventSub!: Subscription;
  errorMessage: string = '';

  constructor(
      private route: ActivatedRoute,
      private eventService: EventService
    ) { }
  ngOnDestroy(): void {
    if(this.eventSub){
      this.eventSub.unsubscribe();
    }
  }

  ngOnInit() {
    this.eventSub = this.eventService.getEvent(+this.route.snapshot.params['id']).subscribe({
      next: event => this.event = event,
      error: err => this.errorMessage = err
    });
  }
}
