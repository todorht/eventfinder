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

    String amenity;

    String name;

    String int_name;

    @JsonProperty("name:en")
    String name_en;

    @JsonProperty("addr:city")
    String city;

    @JsonProperty("addr:city:en")
    String city_en;

    @JsonProperty("addr:country")
    String country;

    String housenumber;

    @JsonProperty("addr:postcode")
    String postcode;

    @JsonProperty("addr:street")
    String street;

    @JsonProperty("addr:street:en")
    String street_en;



}
