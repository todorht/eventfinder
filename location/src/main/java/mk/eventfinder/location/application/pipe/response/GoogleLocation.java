package mk.eventfinder.location.application.pipe.response;

import com.mongodb.client.model.geojson.Geometry;

public class GoogleLocation {

    String business_status;
    Geometry geometry;
    String name;
    String place_id;


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

}
