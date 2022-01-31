import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NbActionsModule, NbButtonModule, NbCalendarWithTimeComponent, NbCardModule, NbDatepickerModule, NbIconModule, NbLayoutModule, NbListModule, NbTimepickerModule, NbToggleModule, NbUserModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
import { DateTimePickerComponent } from './date-time-picker/date-time-picker.component';
import { OsmViewComponent } from './osm-view/osm-view.component';
import { AngularOpenlayersModule } from 'ngx-openlayers';

@NgModule({
  declarations: [
    DateTimePickerComponent,
    OsmViewComponent
  ],
  imports: [
    CommonModule,
    NbTimepickerModule,
    NbDatepickerModule,
    AngularOpenlayersModule
  ],
  exports:[
    DateTimePickerComponent,
    CommonModule,
    FormsModule,
    BrowserAnimationsModule,
    NbLayoutModule,
    NbEvaIconsModule,
    NbUserModule,
    NbActionsModule,
    NbButtonModule,
    NbCardModule,
    NbIconModule,
    NbToggleModule,
    NbListModule,
    NbTimepickerModule,
    NbDatepickerModule,
    OsmViewComponent
  ]
})
export class SharedModule { }
