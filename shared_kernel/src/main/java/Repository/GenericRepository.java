package Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

public interface GenericRepository<T, ID extends Serializable> extends MongoRepository<T,ID> {
}
