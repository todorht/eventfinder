package mk.eventfinder.location.infrastrucure.openStreetMapClient.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Embeddable
@Data
public class Amenity {

    String value;

    public Amenity(String value) {
        this.value = value;
    }
}
