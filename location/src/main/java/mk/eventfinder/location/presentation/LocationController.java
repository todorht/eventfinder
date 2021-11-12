package mk.eventfinder.location.presentation;

import mk.eventfinder.location.infrastrucure.pipe.PlaceReader;
import mk.eventfinder.location.infrastrucure.pipe.vto.GoogleLocation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final PlaceReader placeReader;

    public LocationController(PlaceReader placeReader) {
        this.placeReader = placeReader;
    }

    @GetMapping
    GoogleLocation[] findLocation(){
        return placeReader.getGoogleResponse();
    }
}
