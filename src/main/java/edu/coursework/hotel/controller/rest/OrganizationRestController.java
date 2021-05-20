package edu.coursework.hotel.controller.rest;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    EntertainmentRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.model.Organization;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.organization.impls.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/organization")
public class OrganizationRestController {

    @Autowired
    OrganizationServiceImpl service;

    @GetMapping("/get/all")
    public List<Organization> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Organization getById(@PathVariable("id") String id){
        Organization byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Organization deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Organization create(@RequestBody  Organization organization){
        return service.create(organization);
    }

    @PostMapping ("/update/")
    public  Organization update(@RequestBody  Organization organization){
        return service.update(organization);
    }

}
