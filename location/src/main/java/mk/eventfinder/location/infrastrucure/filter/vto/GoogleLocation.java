package mk.eventfinder.location.infrastrucure.filter.vto;

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

