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
@Document(collection = "organization")
public class Organization {
    @Id
    private String id;

    private String name;
    private Date start;
    private Date finish;
    private int amount;
    private ArrayList<Person> persons;
    private ArrayList<Booking> Booking;

    private Date created_at;
    private Date modified_at;
    private String description;
}
