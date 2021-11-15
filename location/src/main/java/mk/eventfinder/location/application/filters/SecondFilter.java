package mk.eventfinder.location.application.filters;

import mk.eventfinder.location.infrastrucure.openStreetMapClient.vto.Element;

public class SecondFilter extends AbstractFilter<Element, Element> {

    @Override
    public boolean transform(Element input) {
        return input.getTags() != null;
    }
}
