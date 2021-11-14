package mk.eventfinder.location.infrastrucure.openStreetMapClient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.eventfinder.location.infrastrucure.openStreetMapClient.vto.OSMResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class OSMClient {
    private final String uri = "https://api.openstreetmap.org/api/0.6/map?bbox=21.3870,41.9959,21.4125,42.0068";

    private final HttpClient httpClient;
    private ObjectMapper om;
    public OSMClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        this.om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true); // za tagovite da ne pravi problem so nekoj jsontoken
    }

    @PostConstruct
    private void init(){
        this.getResources();
    }

    private void getResources(){
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(HttpRequest.newBuilder()
                            .header("accept", "application/json")
                    .uri(URI.create(uri))
                    .build(), HttpResponse.BodyHandlers.ofString());
            OSMResponse osmResponse = om.readValue(response.body(),OSMResponse.class);

            System.out.println(osmResponse.getElements());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
