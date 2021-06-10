package edu.coursework.hotel.model;

/*
    @author:    Slava
    @project:    Hotel
    @class:    Client
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
@Document(collection = "client")
public class Client {
@Id
    private String id;

    private Person person;
    private ArrayList<Booking> bookings;

    private Date created_at;
    private Date modified_at;
    private String description;
}
