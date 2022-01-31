package com.eventsfinder.event.domain.model.image;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Base64;

@Entity
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private byte[] image;

    public Image(String type, byte[] image) {
        this.type = type;
        this.image = image;
    }

    public String getImage(){
        return type + Base64.getMimeEncoder().encodeToString(this.image);
    }
}
