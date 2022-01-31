import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IEvent } from './IEvent';
import { SaveEventRequest } from './model/requests/save-event.request';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private apiServerUrl = environment.eventApiBaseUrl;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http:HttpClient) { }

  public getEvents():Observable<IEvent[]>{
    return this.http.get<IEvent[]>(this.apiServerUrl);
  }

  public getEvent(eventId:number):Observable<IEvent>{
    return this.http.get<IEvent>(this.apiServerUrl + '/' + eventId);
  }

  public deleteEvent(eventId: number): void{
    this.http.delete(this.apiServerUrl + '/delete/' + eventId);
  }

  public addEvent(event: SaveEventRequest): void{
    this.http.post<void>(this.apiServerUrl + '/add', event, this.httpOptions);
  }

  public editEvent(eventId:number, event: IEvent): Observable<Event>{
    return this.http.put<Event>(this.apiServerUrl + '/' + eventId + '/edit',event);
  }

  public addComment(eventId:number, comment:Comment): void{
    this.http.put(this.apiServerUrl + '/' + eventId + '/comment',comment);
  }
}

