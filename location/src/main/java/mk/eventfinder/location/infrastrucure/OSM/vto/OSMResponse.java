package mk.eventfinder.location.infrastrucure.OSM.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OSMResponse extends ValueObject {
    Collection<Element> elements;
}
