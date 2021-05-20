package edu.coursework.hotel.model;

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
@Document(collection = "floor")
public class Floor {
    @Id
    private String id;

    private int numberFloor;
    private ArrayList<Person> cleaners;
    private ArrayList<Room> rooms;

    private Date created_at;
    private Date modified_at;
    private String description;
}
