package com.eventsfinder.event.service;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.model.comment.Comment;
import com.eventsfinder.event.domain.model.event.Event;
import com.eventsfinder.event.dto.EventDto;

import java.util.List;
import java.util.Optional;

public interface EventService {
    void addComment(Long id, Comment comment);

    void editEvent(EventDto event);

    List<Event> findAll();

    Event save(EventDto event);

    Optional<Event> findById(Long id);

    void deleteById(Long id);

}
