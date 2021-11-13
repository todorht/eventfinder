package mk.eventfinder.location.infrastrucure.pipe.vto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoogleLocation{
    Geometry geometry;
    String name;
    String place_id;
    String vicinity;

}

