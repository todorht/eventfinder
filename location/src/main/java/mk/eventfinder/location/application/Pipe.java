package mk.eventfinder.location.application;

import mk.eventfinder.location.application.filters.Filter;
import mk.eventfinder.location.infrastrucure.OSM.vto.Element;
import mk.eventfinder.location.infrastrucure.repository.ElementRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Pipe {

    Filter firstFilter = new Filter();

    private final ElementRepository elementRepository;

    public Pipe(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public void start(Collection<Element> param){
        param.stream()
                .forEach(elementRepository::save);
    }


}
