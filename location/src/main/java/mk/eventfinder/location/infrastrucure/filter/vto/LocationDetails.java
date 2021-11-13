package mk.eventfinder.location.infrastrucure.filter.vto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDetails {
    String formatted_address;
    String name;
    String place_id;
}
