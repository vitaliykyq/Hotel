package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {

    private String id;

    private String type;
    private int price;
    private int cost;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;


    public Services(String type, int price, int cost) {
        this.type = type;
        this.price = price;
        this.cost = cost;
    }
}
