package edu.coursework.hotel.controller.rest;

/*
    @author:    Slava
    @project:    Hotel
    @class:    ServicesRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.model.Services;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.services.impls.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/services")
public class ServicesRestController {

    @Autowired
    ServicesServiceImpl service;

    @GetMapping("/get/all")
    public List<Services> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Services getById(@PathVariable("id") String id){
        Services byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Services deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Services create(@RequestBody  Services services){
        return service.create(services);
    }

    @PostMapping ("/update/")
    public  Services update(@RequestBody  Services services){
        return service.update(services);
    }

}
