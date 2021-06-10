package edu.coursework.hotel.controller.rest;

/*
    @author:    Slava
    @project:    Hotel
    @class:    CorpsRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Corps;
import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.service.corps.impls.CorpsServiceImpl;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corps")
public class CorpsRestController {

    @Autowired
    CorpsServiceImpl service;

    @GetMapping("/get/all")
    public List<Corps> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Corps getById(@PathVariable("id") String id){
        Corps byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Corps deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Corps create(@RequestBody  Corps corps){
        return service.create(corps);
    }

    @PostMapping ("/update/")
    public  Corps update(@RequestBody  Corps corps){
        return service.update(corps);
    }

}
