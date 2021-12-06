package mk.eventfinder.location.infrastrucure.repository;

import Repository.GenericRepository;
import mk.eventfinder.location.domain.model.Location;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends GenericRepository<Location, Long> {
}
