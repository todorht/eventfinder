package mk.eventfinder.location.infrastrucure.OSM.vto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
public class Tags {

    String name;

    String amenity;

    @JsonProperty("addr:city")
    String city;

    @JsonProperty("addr:street")
    String street;

}
