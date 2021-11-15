package mk.eventfinder.location.infrastrucure.openStreetMapClient.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mk.eventfinder.location.application.vto.ValueObject;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Element extends ValueObject {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    String type;
    long uid;
    double lat;
    double lon;
    String user;
    @Embedded
    Tags tags;

}
