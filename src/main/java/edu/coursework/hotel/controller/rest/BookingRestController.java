package edu.coursework.hotel.controller.rest;

/*
    @author:    Slava
    @project:    Hotel
    @class:    BookingRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Booking;
import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.service.booking.impls.BookingServiceImpl;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingRestController {

    @Autowired
    BookingServiceImpl service;

    @GetMapping("/get/all")
    public List<Booking> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Booking getById(@PathVariable("id") String id){
        Booking byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Booking deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Booking create(@RequestBody  Booking booking){
        return service.create(booking);
    }

    @PostMapping ("/update/")
    public  Booking update(@RequestBody  Booking booking){
        return service.update(booking);
    }

    @GetMapping("/get/roomWithDateOfEviction/{eviction}")
    public Object getRoomWithDateOfEviction(@PathVariable("eviction") String eviction){
        return service.getRoomWithDateOfEviction(eviction) ;
    }
}
