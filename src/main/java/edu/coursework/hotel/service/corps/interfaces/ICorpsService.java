package edu.coursework.hotel.service.corps.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    ICorpsService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Corps;

import java.util.List;

public interface ICorpsService {

    Corps getById(String id);
    Corps create(Corps corps);
    Corps update(Corps corps);
    Corps delete(String id);
    List<Corps> getAll();
}
