package mk.eventfinder.location.infrastrucure.pipe;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import mk.eventfinder.location.domain.model.Location;
import mk.eventfinder.location.infrastrucure.pipe.vto.GoogleLocation;
import mk.eventfinder.location.infrastrucure.pipe.vto.LocationDetails;
import mk.eventfinder.location.infrastrucure.pipe.vto.LocationDetailsResponse;
import mk.eventfinder.location.infrastrucure.pipe.vto.LocationResponse;

import mk.eventfinder.location.infrastrucure.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static mk.eventfinder.location.LocationApplication.*;


@Service
public class LocationReader {


    private final LocationRepository locationRepository;

    private HttpClient httpClient;
    private HttpResponse<String> response;
    private ObjectMapper objectMapper;

    public LocationReader(LocationRepository locationRepository, HttpClient httpClient) {
        this.locationRepository = locationRepository;
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @PostConstruct
    private void init(){
        this.getFromGoogle(placesUrl, "start");
    }

    private HttpRequest getJsonResultFromUrl(String uri) {
        return HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(uri))
                .build();
    }

    private GoogleLocation[] getFromGoogle(String placesUrl, String nextPageToken){

        StringBuilder stringBuilder = null;
        if(nextPageToken == null){
            return null;
        } else if(nextPageToken.equals("start")) {
           stringBuilder = new StringBuilder(placesUrl + googleApiKey);
        } else {
            stringBuilder = new StringBuilder(placesUrl + googleApiKey).append("&pagetoken=");
        }


        try {
            this.response = this.httpClient.send(this.getJsonResultFromUrl(stringBuilder.toString()), HttpResponse.BodyHandlers.ofString());
            LocationResponse googleResponse = this.objectMapper.readValue(response.body(), LocationResponse.class);
            List<Location> locationList =  Arrays.stream(googleResponse.getResults()).map(l -> {
                LocationDetails locationDetails = getPlaceDetails(l.getPlace_id());
                return new Location(l.getPlace_id(),l.getName(),null,null,locationDetails.getFormatted_address(),l.getGeometry().getLocation().getLat(), l.getGeometry().getLocation().getLng());
            })
                    .collect(Collectors.toList());
            locationList.forEach(this.locationRepository::save);
            return getFromGoogle(stringBuilder.toString(), googleResponse.getNext_page_token());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private LocationDetails getPlaceDetails(String placeId){
        try {
            this.response = this.httpClient.send(this.getJsonResultFromUrl(placeDetailsUrl + placeId + googleApiKey),HttpResponse.BodyHandlers.ofString());
            return this.objectMapper.readValue(response.body(),LocationDetailsResponse.class).getResult();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }





}
