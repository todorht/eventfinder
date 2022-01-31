package com.eventsfinder.event.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Location {
    @JsonProperty
    public Long locationId;
    @Embedded
    public Address address;
    @JsonProperty
    public double latitude;
    @JsonProperty
    public double longitude;
    public String locationName;
}

@Embeddable
class Address{
    @JsonProperty
    @Column(name = "loc_address")
    public String country;
    @JsonProperty
    public String city;
    @JsonProperty
    public String address;
}