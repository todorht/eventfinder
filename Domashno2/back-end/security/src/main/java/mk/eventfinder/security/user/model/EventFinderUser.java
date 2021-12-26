package mk.eventfinder.security.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("eventfinderusers")
@AllArgsConstructor
@NoArgsConstructor
public class EventFinderUser {

    @Id
    public String username;
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    public Role role;

    public EventFinderUser(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}

enum Role{
    USER, ADMIN
}