package mk.eventfinder.location.infrastrucure.repository;

import Repository.GenericMongoRepository;
import mk.eventfinder.location.domain.model.Location;

public interface LocationRepository extends GenericMongoRepository<Location, String> {
}
