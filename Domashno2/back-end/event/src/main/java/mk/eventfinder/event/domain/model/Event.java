package mk.eventfinder.event.domain.model;

import mk.eventfinder.event.domain.valueobjects.Location;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Event {
    private Long eventId;
    private Boolean isOnline;
    private Boolean isPrivate;
    private String status;
    private String name;
    private String createdByUser;
    private EventInformation information;
    private List<Comment> comments;
    private Location location;

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
