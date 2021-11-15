package mk.eventfinder.location.infrastrucure.repository;

import mk.eventfinder.location.infrastrucure.OSM.vto.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Long> {
}
