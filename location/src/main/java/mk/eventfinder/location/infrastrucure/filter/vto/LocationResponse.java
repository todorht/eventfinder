package mk.eventfinder.location.infrastrucure.filter.vto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {

    @JsonIgnore
    String[] html_attributions;
    String next_page_token;
    GoogleLocation[] results;
    String status;
}


