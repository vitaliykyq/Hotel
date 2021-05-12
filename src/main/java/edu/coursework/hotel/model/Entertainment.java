package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entertainment {

    private String id;

    private String type;
    private int price;
    private int cost;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;
}
