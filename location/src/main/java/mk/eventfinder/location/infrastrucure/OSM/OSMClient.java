package mk.eventfinder.location.infrastrucure.OSM;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.Nullable;
import mk.eventfinder.location.application.Pipe;
import mk.eventfinder.location.infrastrucure.OSM.vto.Element;
import mk.eventfinder.location.infrastrucure.OSM.vto.OSMResponse;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OSMClient {
    private final static String OSMApi = "https://lz4.overpass-api.de/api/interpreter";

    private final HttpClient httpClient;
    private final ObjectMapper om;
    private final Pipe pipe;

    private List<HttpRequest> failedRequests = new ArrayList<>();

    public OSMClient(HttpClient httpClient, Pipe pipe) {
        this.httpClient = httpClient;
        this.pipe = pipe;
        this.om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true); // za tagovite da ne pravi problem so nekoj jsontoken
    }

    @PostConstruct
    private void init() {
        this.getResources();
    }

    private List<HttpRequest> getRequests() {
        List<HttpRequest> urls = new ArrayList<>();
        for (AmenityTypes type : AmenityTypes.values()) {
            var url = OSMApi + String.format("?data=[out:json];node[amenity=%s](40.9980,20.4146,42.0035,21.4300);out%%20meta;",type.value);
            urls.add(HttpRequest.newBuilder()
                    .header("accept", "application/json")
                    .uri(URI.create(url))
                    .build());
        }
        return urls;
    }

    private Collection<Element> getElements(HttpRequest request){
        HttpResponse<String> response;
        OSMResponse osmResponse;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode()!=200) {
                System.out.println(request.uri());
                System.out.println(response.statusCode());
                this.failedRequests.add(request);
                return null;
            } else {
                osmResponse = om.readValue(response.body(), OSMResponse.class);
                return osmResponse.getElements();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void getResources() {

            Collection<Element> elements = getElements(getRequests().get(0));
            if(elements != null){
                elements.forEach(pipe::add);
            }
            try {
                Thread.sleep(10000); //ne ni dozvoluva api-to da isprakjame mnogu baranja za kratok period
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("GOTONO");
        pipe.start();
    }
}
