package edu.coursework.hotel.controller.rest;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    ClientRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.service.client.impls.ClientServiceImpl;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientRestController {

    @Autowired
    ClientServiceImpl service;

    @GetMapping("/get/all")
    public List<Client> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Client getById(@PathVariable("id") String id){
        Client byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Client deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Client create(@RequestBody  Client client){
        return service.create(client);
    }

    @PostMapping ("/update/")
    public  Client update(@RequestBody  Client client){
        return service.update(client);
    }



}
