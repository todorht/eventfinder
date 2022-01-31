package com.eventsfinder.event.dto;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.valueobjects.ContactValue;
import com.eventsfinder.event.domain.valueobjects.Location;

public class EventDto {
    public Long eventId;
    public   boolean isOnline;
    public String name;
    public String createBy;
    public String base64image;
    public String description;
    public ContactValue contact ;
    public Category category;
    public Location location;
}
