package edu.coursework.hotel.model.object;

import edu.coursework.hotel.model.Booking;
import lombok.Data;

import java.util.Date;

@Data
public class objBooking {
    private Booking booking;
    private Date bookingDate;
}
