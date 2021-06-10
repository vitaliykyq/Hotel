package edu.coursework.hotel.controller.ui;

/*
    @author:    Slava
    @project:    Hotel
    @class:    OrganizationUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.booking.impls.BookingServiceImpl;
import edu.coursework.hotel.service.organization.impls.OrganizationServiceImpl;
import edu.coursework.hotel.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/organization")
@Controller
public class OrganizationUIController {

    @Autowired
    OrganizationServiceImpl organizationService;

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    BookingServiceImpl bookingService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Organization> organizationList = organizationService.getAll();
        model.addAttribute("organizationList", organizationList);

        return "organization/organizationList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Organization organization = organizationService.getById(id);
        model.addAttribute("organization", organization);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<Booking> bookingListId = bookingService.getAll();
        model.addAttribute("bookingListId", bookingListId);
        return "organization/updateOrganization";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("organization") @RequestBody  Organization organization ) {

        organizationService.update(organization);
        return "redirect:/ui/organization/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Organization organization  = new Organization();
        model.addAttribute("organization", organization);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<Booking> bookingListId = bookingService.getAll();
        model.addAttribute("bookingListId", bookingListId);
        return "organization/newOrganization";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("organization") @RequestBody Organization organization) {
        model.addAttribute("organization", organizationService.create(organization));
        return "redirect:/ui/organization/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        organizationService.delete(id);
        return "redirect:/ui/organization/get/all";
    }
}
