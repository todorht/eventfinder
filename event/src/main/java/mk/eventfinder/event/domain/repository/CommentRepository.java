package mk.eventfinder.event.domain.repository;

import Repository.GenericRepository;
import mk.eventfinder.event.domain.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends GenericRepository<Comment, Long> {
}
