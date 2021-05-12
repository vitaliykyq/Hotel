package edu.coursework.hotel.model.object;

import lombok.Data;

import java.util.Date;

@Data
public class objBooking {
    private edu.coursework.hotel.model.Booking booking;
    private Date bookingDate;
}
