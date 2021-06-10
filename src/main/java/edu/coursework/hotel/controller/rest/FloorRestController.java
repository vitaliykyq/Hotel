package edu.coursework.hotel.controller.rest;

/*
    @author:    Slava
    @project:    Hotel
    @class:    FloorRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.model.Floor;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.floor.impls.FloorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/floor")
public class FloorRestController {

    @Autowired
    FloorServiceImpl service;

    @GetMapping("/get/all")
    public List<Floor> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Floor getById(@PathVariable("id") String id){
        Floor byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Floor deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Floor create(@RequestBody  Floor floor){
        return service.create(floor);
    }

    @PostMapping ("/update/")
    public  Floor update(@RequestBody  Floor floor){
        return service.update(floor);
    }

}
