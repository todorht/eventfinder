package mk.eventfinder.location.presentation;

import mk.eventfinder.location.application.pipe.GoogleClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final GoogleClient googleClient;

    public LocationController(GoogleClient googleClient) {
        this.googleClient = googleClient;
    }

    @GetMapping
    void findLocation(){
        googleClient.findLocation();
    }
}
