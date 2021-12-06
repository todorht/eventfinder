package mk.eventfinder.event.service;

import Repository.IService;
import mk.eventfinder.event.domain.model.Comment;
import mk.eventfinder.event.domain.model.Event;

import java.util.List;

public interface EventService extends IService<Event, Long> {
    void addComment(Long eventId,Comment comment);
    void editEvent(Long eventId, Event event);
    List<Event> findAllByLocationId(Long locationId);
}
