package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Floor {

    private String id;

    private int numberFloor;
    private ArrayList<Person> cleaners;
    private ArrayList<Room> rooms;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;
}
