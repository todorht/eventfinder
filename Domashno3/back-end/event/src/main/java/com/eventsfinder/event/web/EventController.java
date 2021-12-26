package com.eventsfinder.event.web;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.model.Comment;
import com.eventsfinder.event.domain.model.Event;
import com.eventsfinder.event.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents(){
        return this.eventService.findAll();
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable Long eventId){
        Optional<Event> event = this.eventService.findById(eventId);
        return event.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{eventId}")
    public void deleteEvent(@PathVariable Long eventId){
        this.eventService.deleteById(eventId);
    }

    @PatchMapping("/edit/{eventId}")
    public void editEvent(@PathVariable Long eventId, @RequestBody Event event){
        this.eventService.editEvent(eventId,event);
    }

    @PostMapping("/add")
    public void addEvent(@RequestBody Event event)
    {
        this.eventService.save(event);
    }

    @PutMapping("/comment/{eventId}")
    public void addComment(@PathVariable Long eventId, @RequestBody Comment comment){
        this.eventService.addComment(eventId, comment);
    }

    @GetMapping("/byCategory")
    public List<Event> findByCategory(@RequestParam Category category)
    {
        return this.eventService.findByCategory(category);
    }

    @GetMapping("/byCountry")
    public List<Event> findByCountry(@RequestParam String country)
    {
        return this.eventService.findAllByCountry(country);
    }

    @GetMapping("/byCity")
    public List<Event> findByCity(@RequestParam String city)
    {
        return this.eventService.findAllByCity(city);
    }

      @GetMapping("/byAddress")
    public List<Event> findByAddress(@RequestParam String address)
    {
        return this.eventService.findAllByAddress(address);
    }
}

