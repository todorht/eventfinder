package com.eventsfinder.event.domain.model.event;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.model.comment.Comment;
import com.eventsfinder.event.domain.model.image.Image;
import com.eventsfinder.event.domain.valueobjects.ContactValue;
import com.eventsfinder.event.domain.valueobjects.Location;
import com.eventsfinder.event.dto.EventDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    @JsonProperty
    private String name;
    private Long createBy;
    private Boolean isOnline;
    @OneToOne
    private Image image;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;
    @OneToMany
    private List<Comment> comments;
    @Embedded
    private ContactValue contact;
    @Embedded
    @JsonProperty
    private Location location;

    public Event(String name, Long createBy, Boolean isOnline, Image image, Category category, String description, ContactValue contact, Location location) {
        this.name = name;
        this.createBy = createBy;
        this.isOnline = isOnline;
        this.image = image;
        this.category = category;
        this.description = description;
        this.contact = contact;
        this.location = location;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
