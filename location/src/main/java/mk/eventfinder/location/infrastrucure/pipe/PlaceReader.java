package mk.eventfinder.location.infrastrucure.pipe;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.eventfinder.location.infrastrucure.pipe.vto.GoogleLocation;
import mk.eventfinder.location.infrastrucure.pipe.vto.GoogleResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;


@Service
public class PlaceReader {

    public static String placesUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.998328,%2021.417523&radius=50500&type=stadium&key=AIzaSyAqsJ2jyqHJC9H5dZeUnuHeiypl7v5yMhI";
    private final RestTemplate restTemplate;
    private GoogleResponse googleResponse;

    public PlaceReader(RestTemplate restTemplate) {
        this.googleResponse = null;
        this.restTemplate = restTemplate;
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }


    public GoogleLocation[] getResource(){

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(placesUrl))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request,HttpResponse.BodyHandlers.ofString()) ;

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            this.googleResponse = objectMapper.readValue(response.body(), GoogleResponse.class);
            return this.googleResponse.getResults();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public GoogleLocation[] getGoogleResponse(){
            return this.getResource();
//       return Arrays.stream(this.getResource().getResults()).findFirst().get();
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(placesUrl);
    }

//    @PostConstruct
//    private void init(){
//        restTemplate.getForEntity(URI.create(placesUrl),FirstRes)
//
//    }
}
