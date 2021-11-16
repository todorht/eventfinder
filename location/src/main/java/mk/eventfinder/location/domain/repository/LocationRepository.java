package mk.eventfinder.location.domain.repository;

import mk.eventfinder.location.domain.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface LocationRepository extends MongoRepository<Location, Long> {
}
