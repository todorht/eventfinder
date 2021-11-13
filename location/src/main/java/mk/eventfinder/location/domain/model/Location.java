package mk.eventfinder.location.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mk.eventfinder.location.infrastrucure.pipe.vto.Geometry;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String country;
    @JsonProperty
    private String city;
    @JsonProperty
    private String address;
    @JsonProperty
    private double latitude;
    @JsonProperty
    private double longitude;

}
