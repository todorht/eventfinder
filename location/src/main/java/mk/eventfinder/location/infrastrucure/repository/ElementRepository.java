package mk.eventfinder.location.infrastrucure.repository;

import Repository.GenericRepository;
import mk.eventfinder.location.infrastrucure.openStreetMapClient.vto.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Long> {
}
