package mk.eventfinder.location.infrastrucure.OSM.vto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OSMResponse {
    Collection<Element> elements;
}
