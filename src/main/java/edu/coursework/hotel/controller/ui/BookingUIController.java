package edu.coursework.hotel.controller.ui;

/*
    @author:    Slava
    @project:    Hotel
    @class:    BookingUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.booking.impls.BookingServiceImpl;
import edu.coursework.hotel.service.client.impls.ClientServiceImpl;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.room.impls.RoomServiceImpl;
import edu.coursework.hotel.service.services.impls.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/booking")
@Controller
public class BookingUIController {

    @Autowired
    BookingServiceImpl service;

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    RoomServiceImpl roomService;

    @Autowired
    EntertainmentServiceImpl entertainmentService;

    @Autowired
    ServicesServiceImpl servicesService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Booking> bookingList = service.getAll();
        model.addAttribute("bookingList", bookingList);

        return "booking/bookingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Booking booking = service.getById(id);
        model.addAttribute("booking", booking);

        List<Client> clientListId = clientService.getAll();
        model.addAttribute("clientListId", clientListId);

        List<Room> roomListId = roomService.getAll();
        model.addAttribute("roomListId", roomListId);

        List<Entertainment> entertainmentListId = entertainmentService.getAll();
        model.addAttribute("entertainmentListId", entertainmentListId);

        List<Services> servicesListId = servicesService.getAll();
        model.addAttribute("servicesListId", servicesListId);
        return "booking/updateBooking";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("booking") @RequestBody  Booking booking ) {

        service.update(booking);
        return "redirect:/ui/booking/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Booking booking  = new Booking();
        model.addAttribute("booking", booking);

        List<Client> clientListId = clientService.getAll();
        model.addAttribute("clientListId", clientListId);

        List<Room> roomListId = roomService.getAll();
        model.addAttribute("roomListId", roomListId);

        List<Entertainment> entertainmentListId = entertainmentService.getAll();
        model.addAttribute("entertainmentListId", entertainmentListId);

        List<Services> servicesListId = servicesService.getAll();
        model.addAttribute("servicesListId", servicesListId);
        return "booking/newBooking";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("booking") @RequestBody Booking booking) {
        model.addAttribute("booking", service.create(booking));
        return "redirect:/ui/booking/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/booking/get/all";
    }
}
