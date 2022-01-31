import { Component, OnInit, OnDestroy, Input, Output, EventEmitter } from '@angular/core'
import { marker } from './marker.image'
import { proj, View } from 'openlayers'
import { HttpClient } from '@angular/common/http'
import { Subscription } from 'rxjs'
import { GeoLocationService } from './geo-location.service.ts.service'
import { Location, Point } from '../../event/IEvent'

@Component({
  selector: 'app-osm-view',
  templateUrl: './osm-view.component.html',
  styleUrls: ['./osm-view.component.scss'],
  providers: [HttpClient, GeoLocationService]
})
export class OsmViewComponent implements OnInit, OnDestroy {
  @Input()
  geoReverseService = 'https://nominatim.openstreetmap.org/reverse?key=iTzWSiYpGxDvhATNtSrqx5gDcnMOkntL&format=json&addressdetails=1&lat={lat}&lon={lon}'

  @Input()
  width: string = "400px"
  @Input()
  height: string = "250px"

  @Input()
  latitude = 41.9981
  @Input()
  longitude = 21.4254

  @Input()
  latitudePointer = 41.9981
  @Input()
  longitudePointer = 21.4254

  @Input()
  showControlsZoom: boolean | undefined
  @Input()
  titleZoomIn = 'Zoom in'
  @Input()
  titleZoomOut = 'Zoom out'
  @Input()
  showControlsCurrentLocation: boolean | undefined
  @Input()
  titleCurrentLocation = 'Current location'

  @Input()
  opacity = 1
  @Input()
  zoom = 14

  markerImage = marker

  reverseGeoSub: Subscription | undefined
  position: any
  dirtyPosition: boolean | undefined

  @Output()
  addressChanged = new EventEmitter<Location>()

  constructor(private httpClient: HttpClient, private geoLocationService: GeoLocationService) {
  }

  ngOnInit() {
    if (this.showControlsCurrentLocation) {
      this.geoLocationService.getLocation().subscribe((position) => {
        this.position = position
        if (!this.dirtyPosition) {
          this.dirtyPosition = true
          this.longitude = this.longitudePointer = this.position.coords.longitude
          this.latitude = this.latitudePointer = this.position.coords.latitude
        }
      })
    }
  }

  ngOnDestroy() {
    if (this.reverseGeoSub) {
      this.reverseGeoSub.unsubscribe()
    }
  }
  onSingleClick(event: any) {
    const lonlat = proj.transform(event.coordinate, 'EPSG:3857', 'EPSG:4326')
    this.longitudePointer = lonlat[0]
    this.latitudePointer = lonlat[1]

    const service = (this.geoReverseService || '')
    .replace(new RegExp('{lon}', 'ig'), `${this.longitudePointer}`)
    .replace(new RegExp('{lat}', 'ig'), `${this.latitudePointer}`)
  this.reverseGeoSub = this.httpClient.get<Location>(service).subscribe(data => {
    console.log(data);
    this.addressChanged.emit({
      address:{
        city: data.address.city?.toString(),
        country: data.address.country?.toString(),
        road: data.address.road?.toString()
      },
      lat: data.lat,
      lon: data.lon,

    });
  })
  }
  increaseOpacity() {
    this.opacity += 0.1
  }

  decreaseOpacity() {
    this.opacity -= 0.1
  }
  increaseZoom() {
    this.zoom++
  }
  decreaseZoom() {
    this.zoom--
  }

  setCurrentLocation(event: any) {
    if (this.position) {
      this.longitude = this.longitudePointer = this.position.coords.longitude
      this.latitude = this.latitudePointer = this.position.coords.latitude
    }
  }

}
