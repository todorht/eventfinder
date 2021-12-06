package mk.eventfinder.usermanagement.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
public class User {


    @Id
    private String username;
    private String password;
}
