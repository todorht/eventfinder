package mk.eventfinder.location.infrastrucure.openStreetMapClient.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OSMResponse {
    Collection<Node> elements;
}
