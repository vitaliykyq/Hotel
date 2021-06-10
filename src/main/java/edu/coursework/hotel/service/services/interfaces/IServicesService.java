package edu.coursework.hotel.service.services.interfaces;

/*
    @author:    Slava
    @project:    Hotel
    @class:    IServicesService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Room;
import edu.coursework.hotel.model.Services;

import java.util.List;

public interface IServicesService {

    Services getById(String id);
    Services create(Services services);
    Services update(Services services);
    Services delete(String id);
    List<Services> getAll();
}
