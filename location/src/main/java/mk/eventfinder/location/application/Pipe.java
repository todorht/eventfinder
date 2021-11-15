package mk.eventfinder.location.application;

import mk.eventfinder.location.application.filters.FirstFilter;
import mk.eventfinder.location.application.filters.SecondFilter;
import mk.eventfinder.location.application.filters.FourthFilter;
import mk.eventfinder.location.application.filters.ThridFilter;
import mk.eventfinder.location.infrastrucure.openStreetMapClient.vto.Element;
import mk.eventfinder.location.infrastrucure.repository.ElementRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Pipe {

    FirstFilter firstFilter = new FirstFilter();
    SecondFilter secondFilter = new SecondFilter();
    ThridFilter thridFilter = new ThridFilter();
    FourthFilter fourthFilter = new FourthFilter();

    private final ElementRepository elementRepository;

    public Pipe(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public void start(Collection<Element> param){
        param.stream()
                .filter(element -> firstFilter.transform(element))
                .filter(element -> secondFilter.transform(element))
                .filter(element -> thridFilter.transform(element))
                .filter(element -> fourthFilter.transform(element))
                .forEach(elementRepository::save);
    }


}
