package mk.eventfinder.event.service.impl;

import mk.eventfinder.event.domain.model.Comment;
import mk.eventfinder.event.domain.model.Event;
import mk.eventfinder.event.domain.repository.CommentRepository;
import mk.eventfinder.event.domain.repository.EventRepository;
import mk.eventfinder.event.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;

    public EventServiceImpl(EventRepository eventRepository, CommentRepository commentRepository) {
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event save(Event entity) {
        return this.eventRepository.save(entity);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public void delete(Event entity) {
        this.eventRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public void addComment(Long eventId,Comment comment) {
        Event event = this.findById(eventId).get();
        event.addComment(comment);
        this.commentRepository.save(comment);
        this.save(event);
    }

    @Override
    public void editEvent(Long eventId, Event editedEvent) {
        this.deleteById(eventId);
        this.save(editedEvent);
    }

    @Override
    public List<Event> findAllByLocationId(Long locationId) {
        return null;
    }
}
