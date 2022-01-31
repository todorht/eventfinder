package com.eventsfinder.event.service.Impl;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.exceptions.EventNotFoundedException;
import com.eventsfinder.event.domain.model.comment.Comment;
import com.eventsfinder.event.domain.model.event.Event;
import com.eventsfinder.event.domain.model.image.Image;
import com.eventsfinder.event.dto.EventDto;
import com.eventsfinder.event.repository.CommentRepository;
import com.eventsfinder.event.repository.EventRepository;
import com.eventsfinder.event.repository.ImageRepository;
import com.eventsfinder.event.service.EventService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;
    private final ImageRepository imageRepository;

    public EventServiceImpl(EventRepository eventRepository, CommentRepository commentRepository, ImageRepository imageRepository) {
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
        this.imageRepository = imageRepository;
    }

    private Event mapToEntity(EventDto eventDto){
        String[] parts = eventDto.base64image.split(",");
        Image image = new Image(parts[0], Base64.getMimeDecoder().decode(parts[1]));
        return new Event(eventDto.name, Long.getLong(eventDto.createBy), eventDto.isOnline, image, eventDto.category, eventDto.description, eventDto.contact, eventDto.location);
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event save(EventDto entity) {
        Event event = this.mapToEntity(entity);
        this.imageRepository.save(event.getImage());
        return this.eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public void addComment(Long eventId, Comment comment) {
        if(this.findById(eventId).isPresent()) {
            Event event = this.findById(eventId).get();
            event.addComment(comment);
            this.commentRepository.save(comment);
            this.eventRepository.save(event);
        }
        else
            throw new EventNotFoundedException(eventId);
    }

    @Override
    public void editEvent(EventDto editedEvent) {
        this.save(editedEvent);
    }

//    @Override
//    public List<Event> findByCategory(Category category) {
//       return this.eventRepository.findAllByCategory(category);
//    }

//    @Override
//    public List<Event> findAllByCountry(String country) {
//        return this.eventRepository.findAllByCountry(country);
//    }
//
//    @Override
//    public List<Event> findAllByCity(String city) {
//        return this.eventRepository.findAllByCity(city);
//
//    }
//
//    @Override
//    public List<Event> findAllByAddress(String address) {
//        return this.eventRepository.findAllByAddress(address);
//    }



}
