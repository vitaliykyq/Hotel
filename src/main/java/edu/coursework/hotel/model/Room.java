package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private String id;

    private int capacity;
    private int price;
    private boolean isFree;
    //Вид номеру
    private int rating;
    private String type;
    private ArrayList<Entertainment> entertainments;
    private ArrayList<Services> services;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;
}
