package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import edu.coursework.hotel.model.object.objBooking;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    private String id;

    private String type;
    private Date start;
    private Date finish;
    private ArrayList<Person> persons;
    private ArrayList<objBooking> objBooking;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;
}
