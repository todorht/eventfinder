package com.eventsfinder.user.domain.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

}
