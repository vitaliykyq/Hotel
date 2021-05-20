package edu.coursework.hotel.service.entertainment.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    IServicesService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Corps;
import edu.coursework.hotel.model.Entertainment;

import java.util.List;

public interface IEntertainmentService {

    Entertainment getById(String id);
    Entertainment create(Entertainment entertainment);
    Entertainment update(Entertainment entertainment);
    Entertainment delete(String id);
    List<Entertainment> getAll();
}
