package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import edu.coursework.hotel.model.object.objDebt;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    private String id;

    private ArrayList<Room> rooms;
    private ArrayList<Entertainment> entertainments;
    private ArrayList<Services> services;
    private Date settlement;
    private Date eviction;
    private ArrayList<objDebt> debts;
    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;
}
