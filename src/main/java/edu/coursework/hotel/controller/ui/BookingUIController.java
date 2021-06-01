package edu.coursework.hotel.controller.ui;

/*
    @author:    Julia
    @project:    Hotel
    @class:    FeedbackUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.Booking;
import edu.coursework.hotel.model.Feedback;
import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.service.booking.impls.BookingServiceImpl;
import edu.coursework.hotel.service.feedback.impls.FeedbackServiceImpl;
import edu.coursework.hotel.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/bookings")
@Controller
public class BookingUIController {

    @Autowired
    BookingServiceImpl service;

    @Autowired
    PersonServiceImpl personService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Booking> bookings = service.getAll();
        model.addAttribute("booking", bookings);

        return "booking/bookingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Booking booking = service.getById(id);
        model.addAttribute("booking", booking);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "booking/updateBooking";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("booking") @RequestBody  Booking booking ) {

        service.update(booking);
        return "redirect:/ui/bookings/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Booking booking  = new Booking();
        model.addAttribute("feedback", booking);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "booking/newBooking";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("feedback") @RequestBody Booking booking) {


            model.addAttribute("feedback", service.create(booking));
            return "redirect:/ui/bookings/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/bookings/get/all";
    }
}
