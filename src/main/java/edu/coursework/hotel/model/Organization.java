package edu.coursework.hotel.model;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    Organization
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
@Document(collection = "organization")
public class Organization {
    @Id
    private String id;

    private String name;
    private String start;
    private String finish;
    private int amount;
    private ArrayList<Person> persons;
    private ArrayList<Booking> bookings;

    private Date created_at;
    private Date modified_at;
    private String description;
}
