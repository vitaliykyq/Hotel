package edu.coursework.hotel.controller.rest;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    EntertainmentRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.repository.EntertainmentRepository;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entertainment")
public class EntertainmentRestController {

    @Autowired
    EntertainmentServiceImpl service;

    @GetMapping("/get/all")
    public List<Entertainment> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Entertainment getById(@PathVariable("id") String id){
        Entertainment byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Entertainment deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Entertainment create(@RequestBody  Entertainment entertainment){
        return service.create(entertainment);
    }

    @PostMapping ("/update/")
    public  Entertainment update(@RequestBody  Entertainment entertainment){
        return service.update(entertainment);
    }

}
