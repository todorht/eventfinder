package mk.eventfinder.location.application.pipe.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FGoogleResponse {

    GoogleLocation[] html_attributions;
    String next_page_token;
    List<GoogleLocation> results;

}
