package edu.coursework.hotel.service.floor.interfaces;

/*
    @author:    Slava
    @project:    Hotel
    @class:    IFloorService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.model.Floor;

import java.util.List;

public interface IFloorService {

    Floor getById(String id);
    Floor create(Floor floor);
    Floor update(Floor floor);
    Floor delete(String id);
    List<Floor> getAll();
}
