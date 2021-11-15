package mk.eventfinder.location.infrastrucure.openStreetMapClient.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@NoArgsConstructor
@Embeddable
@Data
public class Tags {

    @Embedded
    Amenity amenity;



}
