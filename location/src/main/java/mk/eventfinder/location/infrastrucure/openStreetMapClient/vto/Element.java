package mk.eventfinder.location.infrastrucure.openStreetMapClient.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Element {
    String type;
    Long id;
    Long uid;
    Double lat;
    Double lon;
    String user;
    Object tags;
}
