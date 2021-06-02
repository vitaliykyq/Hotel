package edu.coursework.hotel.controller.rest;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    EntertainmentRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.model.Feedback;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.feedback.impls.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/feedback")
public class FeedbackRestController {

    @Autowired
    FeedbackServiceImpl service;

    @GetMapping("/get/all")
    public List<Feedback> getPerson(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public  Feedback getById(@PathVariable("id") String id){
        Feedback byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public  Feedback deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public  Feedback create(@RequestBody  Feedback feedback){
        return service.create(feedback);
    }

    @PostMapping ("/update/")
    public  Feedback update(@RequestBody  Feedback feedback){
        return service.update(feedback);
    }

    @GetMapping("/get/badFeedbacks")
    public Object getBadFeedbacks(){
        return service.getBadFeedbacks() ;
    }
}
