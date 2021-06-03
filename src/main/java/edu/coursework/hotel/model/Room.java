package edu.coursework.hotel.model;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    Room
    @version:    1.0.0
    @since:    26.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "room")
public class Room {
@Id
    private String id;
    private int number;
    private int capacity;
    private int price;
    private boolean isFree;
    //Вид номеру
    private int rating;
    private String type;
    private ArrayList<Entertainment> entertainments;
    private ArrayList<Services> services;

    private Date created_at;
    private Date modified_at;
    private String description;
}
