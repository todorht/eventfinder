package mk.eventfinder.location.application.filters;

import lombok.NoArgsConstructor;
import mk.eventfinder.location.infrastrucure.openStreetMapClient.AmenityTypes;
import mk.eventfinder.location.infrastrucure.openStreetMapClient.vto.Element;

import java.util.Arrays;

@NoArgsConstructor
public class FourthFilter extends AbstractFilter<Element, Element> {

    @Override
    public boolean transform(Element input) {
        for (AmenityTypes type : AmenityTypes.values()) {
            if (input.getTags().getAmenity().getValue().equals(type.value)){
                return true;
            }
        }
        return false;
    }
}