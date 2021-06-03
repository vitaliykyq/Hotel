package edu.coursework.hotel.controller.rest;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonRestController {

    @Autowired
    PersonServiceImpl service;

    @GetMapping("/get/all")
    public List<Person> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Person getById(@PathVariable("id") String id){
        Person byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Person deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Person create(@RequestBody  Person person){
        return service.create(person);
    }

    @PostMapping ("/update/")
    public  Person update(@RequestBody  Person person){
        return service.update(person);
    }

}
