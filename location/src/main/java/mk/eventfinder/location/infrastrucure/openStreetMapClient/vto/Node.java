package mk.eventfinder.location.infrastrucure.openStreetMapClient.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {
    String type;
    Long id;
    Long uid;
    Double lat;
    Double lon;
    String user;
    Object tags;
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Tags{
//   String addr:city;
   String v;

}
