package com.eventsfinder.user.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRole {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long roleId;

    private String name;
}
