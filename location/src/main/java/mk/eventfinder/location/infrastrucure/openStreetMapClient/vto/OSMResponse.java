package mk.eventfinder.location.infrastrucure.openStreetMapClient.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.eventfinder.location.application.vto.ValueObject;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OSMResponse extends ValueObject {
    Collection<Element> elements;
}
