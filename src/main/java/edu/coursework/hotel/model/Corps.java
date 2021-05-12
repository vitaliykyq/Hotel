package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Corps {

    private String id;

    private String address;
    private String classHotel;
    private ArrayList<Floor> floors;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String description;
}
