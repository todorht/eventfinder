package mk.eventfinder.location.infrastrucure.OSM.vto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Element {

    private Long id;

    String type;

    long uid;

    double lat;

    double lon;

    Tags tags;

}
