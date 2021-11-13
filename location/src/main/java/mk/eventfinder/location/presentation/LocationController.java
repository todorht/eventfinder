package mk.eventfinder.location.presentation;

import mk.eventfinder.location.domain.model.Location;
import mk.eventfinder.location.infrastrucure.pipe.LocationReader;

import mk.eventfinder.location.infrastrucure.repository.LocationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationReader placeReader;
    private final LocationRepository locationRepository;

    public LocationController(LocationReader placeReader, LocationRepository locationRepository) {
        this.placeReader = placeReader;
        this.locationRepository = locationRepository;
    }

    @GetMapping
    List<Location> findLocation(){
        return this.locationRepository.findAll();
    }


}
