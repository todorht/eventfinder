package mk.eventfinder.location.domain.repository;

import mk.eventfinder.location.domain.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long>
{

}
