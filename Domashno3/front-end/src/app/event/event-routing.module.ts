import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventFormComponent } from './event-form/event-form.component';
import { EventListComponent } from './event-list/event-list.component';

const routes: Routes = [
  { path:'events', component: EventListComponent, pathMatch: 'full' },
  { path:'events/new', component: EventFormComponent, pathMatch: 'full' },
  { path:'events/:eventId', component: EventDetailsComponent, pathMatch: 'full' },
  { path:'events/:eventId/edit', component: EventFormComponent, pathMatch: 'full' }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class EventRoutingModule { }
