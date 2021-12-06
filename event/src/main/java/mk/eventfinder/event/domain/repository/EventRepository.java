package mk.eventfinder.event.domain.repository;

import Repository.GenericRepository;
import mk.eventfinder.event.domain.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends GenericRepository<Event, Long> {
}
