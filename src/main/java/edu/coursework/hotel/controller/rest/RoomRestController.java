package edu.coursework.hotel.controller.rest;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    EntertainmentRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.model.Room;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.room.impls.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomRestController {

    @Autowired
    RoomServiceImpl service;

    @GetMapping("/get/all")
    public List<Room> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Room getById(@PathVariable("id") String id){
        Room byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Room deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Room create(@RequestBody  Room room){
        return service.create(room);
    }

    @PostMapping ("/update/")
    public  Room update(@RequestBody  Room room){
        return service.update(room);
    }

}
