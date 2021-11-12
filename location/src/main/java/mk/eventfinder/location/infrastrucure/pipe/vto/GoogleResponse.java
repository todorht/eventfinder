package mk.eventfinder.location.infrastrucure.pipe.vto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleResponse implements Serializable {

    @JsonIgnore
    String[] html_attributions;
    String next_page_token;
    GoogleLocation[] results;
    String status;
}

