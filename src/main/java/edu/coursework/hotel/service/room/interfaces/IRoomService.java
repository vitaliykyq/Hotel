package edu.coursework.hotel.service.room.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    IServicesService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.model.Room;

import java.util.List;

public interface IRoomService {

    Room getById(String id);
    Room create(Room room);
    Room update(Room room);
    Room delete(String id);
    List<Room> getAll();
}
