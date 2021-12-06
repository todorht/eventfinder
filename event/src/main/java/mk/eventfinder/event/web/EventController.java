package mk.eventfinder.event.web;

import mk.eventfinder.event.domain.model.Comment;
import mk.eventfinder.event.domain.model.Event;
import mk.eventfinder.event.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents(){
        return this.eventService.findAll();
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable Long eventId){
        Optional<Event> event = this.eventService.findById(eventId);
        return event.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{eventId}/delete")
    public void deleteEvent(@PathVariable Long eventId){
        this.eventService.deleteById(eventId);
    }

    @PutMapping("/{eventId}/edit")
    public void editEvent(@PathVariable Long eventId, @RequestBody Event event){
        this.eventService.editEvent(eventId,event);
    }

    @PutMapping("/{eventId}/comment")
    public void addComment(@PathVariable Long eventId, @RequestBody Comment comment){
        this.eventService.addComment(eventId, comment);
    }
}
