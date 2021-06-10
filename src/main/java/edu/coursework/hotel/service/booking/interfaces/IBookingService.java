package edu.coursework.hotel.service.booking.interfaces;

/*
    @author:    Slava
    @project:    Hotel
    @class:    IBookingService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Booking;
import edu.coursework.hotel.model.Person;

import java.util.List;

public interface IBookingService {

    Booking getById(String id);
    Booking create(Booking booking);
    Booking update(Booking booking);
    Booking delete(String id);
    List<Booking> getAll();
}
