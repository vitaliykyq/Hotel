package edu.coursework.hotel.controller.ui;

/*
    @author:    Slava
    @project:    Hotel
    @class:    ClientUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.booking.impls.BookingServiceImpl;
import edu.coursework.hotel.service.client.impls.ClientServiceImpl;
import edu.coursework.hotel.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/client")
@Controller
public class ClientUIController {

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    BookingServiceImpl bookingService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Client> clientList = clientService.getAll();
        model.addAttribute("clientList", clientList);

        return "client/clientList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Client client = clientService.getById(id);
        model.addAttribute("client", client);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<Booking> bookingListId = bookingService.getAll();
        model.addAttribute("bookingListId", bookingListId);
        return "client/updateClient";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("client") @RequestBody  Client client ) {

        clientService.update(client);
        return "redirect:/ui/client/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Client client  = new Client();
        model.addAttribute("client", client);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<Booking> bookingListId = bookingService.getAll();
        model.addAttribute("bookingListId", bookingListId);
        return "client/newClient";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("feedback") @RequestBody Client client) {
        model.addAttribute("feedback", clientService.create(client));
        return "redirect:/ui/client/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        clientService.delete(id);
        return "redirect:/ui/client/get/all";
    }
}
