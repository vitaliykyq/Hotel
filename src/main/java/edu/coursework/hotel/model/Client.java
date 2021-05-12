package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import edu.coursework.hotel.model.object.objBooking;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private String id;

    private Person person;
    private objBooking booking;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;
}
