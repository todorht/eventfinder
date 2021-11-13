package mk.eventfinder.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class LocationApplication {

    public static String googleApiKey = "&key=AIzaSyAqsJ2jyqHJC9H5dZeUnuHeiypl7v5yMhI";
    public static String placesUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.998328,%2021.417523&radius=50500&type=stadium";
    public static String placeDetailsUrl ="https://maps.googleapis.com/maps/api/place/details/json?place_id=";
    public static void main(String[] args) {
        SpringApplication.run(LocationApplication.class, args);
    }

    @PostConstruct
    public void init(){

    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpClient getHttpClient(){
        return HttpClient.newBuilder().build();
    }

}
