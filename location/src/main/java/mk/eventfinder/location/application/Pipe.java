package mk.eventfinder.location.application;

import mk.eventfinder.location.application.filters.Filter;
import mk.eventfinder.location.domain.model.Location;
import mk.eventfinder.location.domain.service.LocationService;
import mk.eventfinder.location.infrastrucure.OSM.vto.Element;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Pipe {

    private final LocationService locationService;

    Queue<Element> elementList = new LinkedList<>();
    Filter<String> filter = new Filter<>();

    public Pipe(LocationService locationService) {
        this.locationService = locationService;
    }

    public void add(Element element){
        this.elementList.add(element);
    }

    public void start(){
        while (!elementList.isEmpty()){
           Element element = elementList.poll();
           Location location = new Location();

           if (filter.isNull(element.getTags().getName())){
               location.setName(element.getTags().getName());
           } else if(filter.isNull(element.getTags().getName_en())){
               location.setName(element.getTags().getName_en());
           } else {
               continue;
           }

           location.setId(element.getId());

           if(filter.isNull(element.getTags().getCity())){
               location.setCity(element.getTags().getCity());
           }else if(filter.isNull(element.getTags().getCity_en())){
               location.setCity(element.getTags().getCity_en());
           }else{
               location.setCity("Skopje");
           }

            if(filter.isNull(element.getTags().getCountry())){
                location.setCountry(element.getTags().getCountry());
            }else{
                location.setCountry("MK");
            }

            if(filter.isNull(element.getTags().getStreet())){
                location.setAddress(element.getTags().getStreet());
            }else if(filter.isNull(element.getTags().getCity_en())){
                location.setAddress(element.getTags().getStreet_en());
            }

            location.setLongitude(element.getLon());
            location.setLatitude(element.getLat());

            if(location.getName()!=null) {
                this.locationService.save(location);
            }

        }

    }

}
