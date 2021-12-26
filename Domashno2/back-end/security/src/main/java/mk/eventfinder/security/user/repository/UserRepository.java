package mk.eventfinder.security.user.repository;

import Repository.GenericRepository;
import mk.eventfinder.security.user.model.EventFinderUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<EventFinderUser, String> {
    Optional<EventFinderUser> findByUsername(String username);
    Optional<EventFinderUser> findEventFinderUserByEmail(String email);
}
