package mk.eventfinder.location.application.filters;

import mk.eventfinder.location.infrastrucure.OSM.AmenityTypes;
import mk.eventfinder.location.infrastrucure.OSM.vto.Element;

public class Filter<T> {

    public boolean isNull(T tag){
        return tag != null;
    }

}
