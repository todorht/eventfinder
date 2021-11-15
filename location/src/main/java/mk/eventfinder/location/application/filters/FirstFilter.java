package mk.eventfinder.location.application.filters;

import mk.eventfinder.location.infrastrucure.openStreetMapClient.vto.Element;

public class FirstFilter extends AbstractFilter<Element, Element> {

    public boolean transform(Element input) {
        return input.getType().equals("node");
    }
}
