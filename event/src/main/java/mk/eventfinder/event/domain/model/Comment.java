package mk.eventfinder.event.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Comment {
    private Long commentId;
    private Long userId;
    private LocalDate time;
    private String text;
}
