package mk.eventfinder.location.application.pipe;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.eventfinder.location.application.pipe.response.FGoogleResponse;
import mk.eventfinder.location.domain.model.Location;
import org.bson.json.JsonObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;


@Service
public class GoogleClient {

    public static String placesUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.998328,%2021.417523&radius=50500&type=stadium&key=AIzaSyAqsJ2jyqHJC9H5dZeUnuHeiypl7v5yMhI";
    private final RestTemplate restTemplate;

    public GoogleClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }


    public List<Location> findLocation(){

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
            FGoogleResponse googleResponse = objectMapper.readValue(response.body(), new TypeReference<FGoogleResponse>() {});
            System.out.println(googleResponse.getNext_page_token());

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return Collections.emptyList();
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
