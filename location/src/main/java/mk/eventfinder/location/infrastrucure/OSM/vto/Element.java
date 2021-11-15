package mk.eventfinder.location.infrastrucure.OSM.vto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Element extends ValueObject {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    String type;

    long uid;

    double lat;

    double lon;

    @Embedded
    Tags tags;

}
