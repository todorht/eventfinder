package mk.eventfinder.location.infrastrucure.repository;

import mk.eventfinder.location.domain.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Location, Long> {
}
