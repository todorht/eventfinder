import { NgModule } from '@angular/core';
import { EventListComponent } from './event-list/event-list.component';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventFormComponent } from './event-form/event-form.component';
import { SharedModule } from '../shared/shared.module';
import { EventRoutingModule } from './event-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { SafeImageUrlPipe } from './safe-image-url.pipe';
import { ImageComponent } from './event-form/image.component';
import { OsmViewComponent } from '../shared/osm-view/osm-view.component';
import { AngularOpenlayersModule } from 'ngx-openlayers';
import { CommentComponent } from './comment/comment.component';

@NgModule({
  declarations: [
    EventListComponent,
    EventDetailsComponent,
    EventFormComponent,
    ImageComponent,
    SafeImageUrlPipe,
    CommentComponent
  ],
  imports: [
    SharedModule,
    BrowserModule,
    EventRoutingModule
  ],
  exports: [SharedModule]
})
export class EventModule { }
