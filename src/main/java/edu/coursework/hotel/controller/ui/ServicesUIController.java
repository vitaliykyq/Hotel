package edu.coursework.hotel.controller.ui;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    ServicesUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.services.impls.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/services")
@Controller
public class ServicesUIController {

    @Autowired
    ServicesServiceImpl servicesService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Services> servicesList = servicesService.getAll();
        model.addAttribute("servicesList", servicesList);

        return "services/servicesList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Services services = servicesService.getById(id);
        model.addAttribute("services", services);
        return "services/updateServices";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("services") @RequestBody  Services services ) {

        servicesService.update(services);
        return "redirect:/ui/services/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Services services  = new Services();
        model.addAttribute("services", services);
        return "services/newServices";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("services") @RequestBody Services services) {
        model.addAttribute("services", servicesService.create(services));
        return "redirect:/ui/services/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        servicesService.delete(id);
        return "redirect:/ui/services/get/all";
    }
}
