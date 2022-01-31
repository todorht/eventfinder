package com.eventsfinder.event.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContactValue {
    @Column(name = "contact_name")
    private String contactName;
    private String phoneNumber;
    private String email;
}

