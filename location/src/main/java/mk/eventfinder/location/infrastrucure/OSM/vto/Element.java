package mk.eventfinder.location.infrastrucure.OSM.vto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Element {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    String type;

    long uid;

    double lat;

    double lon;

    Tags tags;

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", uid=" + uid +
                ", lat=" + lat +
                ", lon=" + lon +
                ", tags=" + tags +
                '}';
    }
}
