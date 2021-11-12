package mk.eventfinder.location.infrastrucure.pipe.vto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class GoogleLocation {
    @JsonIgnoreProperties
    String business_status;

    Geometry geometry;

    @JsonIgnoreProperties
    String icon;
    @JsonIgnoreProperties
    String icon_background_color;
    @JsonIgnoreProperties
    Object icon_mask_base_uri;
    String name;
    @JsonIgnoreProperties
    Object opening_hours;
    @JsonIgnoreProperties
    Object photos;

    String place_id;
    @JsonIgnoreProperties
    Object plus_code;
    @JsonIgnoreProperties
    double rating;
    @JsonIgnoreProperties
    String reference;
    @JsonIgnoreProperties
    String scope;
    @JsonIgnoreProperties
    Object[] types;
    @JsonIgnoreProperties
    int user_ratings_total;
    String vicinity;
}

class Geometry{
    ILocation location;
    Object viewport;
}

class ILocation{
    Long lat;
    Long lng;
}




//     "business_status" : "OPERATIONAL",
//             "geometry" : {
//        "location" : {
//            "lat" : 41.9678985,
//                    "lng" : 20.9832752
//        },
//        "viewport" : {
//            "northeast" : {
//                "lat" : 41.96947318029149,
//                        "lng" : 20.9847271302915
//            },
//            "southwest" : {
//                "lat" : 41.9667752197085,
//                        "lng" : 20.98202916970849
//            }
//        }
//        "name" : "Brvenica Stadium",
//                place_id" : "ChIJPbEp3hb6UxMREsiXTNS3Too"

