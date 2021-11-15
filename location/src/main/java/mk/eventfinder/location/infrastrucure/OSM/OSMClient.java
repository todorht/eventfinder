package mk.eventfinder.location.infrastrucure.OSM;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.eventfinder.location.application.Pipe;
import mk.eventfinder.location.infrastrucure.OSM.vto.OSMResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class OSMClient {
    private String uri1stPart = "https://www.overpass-api.de/api/interpreter?data=[out:json];node[amenity=";
    private String uri2ndPart = "](40.9980,20.4146,42.0035,21.4300);out%20meta;";

    private final HttpClient httpClient;
    private ObjectMapper om;
    private final Pipe pipe;


    public OSMClient(HttpClient httpClient, Pipe pipe) {
        this.httpClient = httpClient;
        this.pipe = pipe;
        this.om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true); // za tagovite da ne pravi problem so nekoj jsontoken
    }

    @PostConstruct
    private void init(){
        this.getResources();
    }

    private void getResources(){
        HttpResponse<String> response;
        String uri = "";
        try {

            for (AmenityTypes type : AmenityTypes.values()) {
                uri = uri1stPart + type.value + uri2ndPart;
                response = httpClient.send(HttpRequest.newBuilder()
                        .header("accept", "application/json")
                        .uri(URI.create(uri))
                        .build(), HttpResponse.BodyHandlers.ofString());

                OSMResponse osmResponse = om.readValue(response.body(), OSMResponse.class);

                pipe.start(osmResponse.getElements());
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
