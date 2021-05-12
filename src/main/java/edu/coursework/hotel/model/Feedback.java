package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    private String id;

    private String response;
    private int stars;
    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Feedback(String id, String response, int stars, Person person) {
        this.id = id;
        this.response = response;
        this.stars = stars;
        this.person = person;
        created_at = LocalDateTime.now();
    }
}
