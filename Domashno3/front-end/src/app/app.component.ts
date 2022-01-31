import { Component, OnInit } from '@angular/core';
import {  ActivatedRoute, Router } from '@angular/router';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'eventfinder-app';



  constructor(private router: Router,
              private route: ActivatedRoute,
              private authService: AuthService) {
  }
  ngOnInit(): void {
    
    if (this.route.snapshot.url.length >= 1){
      this.router.navigate(["/events"]);
    }

  }

}
