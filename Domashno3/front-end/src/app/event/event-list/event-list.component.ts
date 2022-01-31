import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { EventService } from '../event.service';
import { IEvent } from '../IEvent';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit, OnDestroy {

  eventSub!: Subscription;
  events: IEvent[] = [];

  constructor(private eventService: EventService) { }

  ngOnDestroy(): void {
    this.eventSub.unsubscribe();
  }

  ngOnInit(): void {
    this.eventSub = this.eventService.getEvents().subscribe({
      next: events => this.events = events,
    })
  }

}
