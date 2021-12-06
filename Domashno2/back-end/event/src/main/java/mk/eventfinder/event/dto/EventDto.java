package mk.eventfinder.event.dto;

import mk.eventfinder.event.domain.model.Comment;
import mk.eventfinder.event.domain.model.EventInformation;
import mk.eventfinder.event.domain.valueobjects.Location;

import java.util.List;

public class EventDto {
    private Boolean isOnline;
    private Boolean isPrivate;
    private String status;
    private String name;
    private Long createdByUser;
    private EventInformation information;
    private List<Comment> comments;
    private Location location;
}
