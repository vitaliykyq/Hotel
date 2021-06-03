package edu.coursework.hotel.controller.ui;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    EntertainmentUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/entertainment")
@Controller
public class EntertainmentUIController {

    @Autowired
    EntertainmentServiceImpl entertainmentService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Entertainment> entertainmentList = entertainmentService.getAll();
        model.addAttribute("entertainmentList", entertainmentList);

        return "entertainment/entertainmentList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Entertainment entertainment = entertainmentService.getById(id);
        model.addAttribute("entertainment", entertainment);
        return "entertainment/updateEntertainment";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("entertainment") @RequestBody  Entertainment entertainment ) {

        entertainmentService.update(entertainment);
        return "redirect:/ui/entertainment/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Entertainment entertainment  = new Entertainment();
        model.addAttribute("entertainment", entertainment);
        return "entertainment/newEntertainment";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("entertainment") @RequestBody Entertainment entertainment) {
        model.addAttribute("entertainment", entertainmentService.create(entertainment));
        return "redirect:/ui/entertainment/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        entertainmentService.delete(id);
        return "redirect:/ui/entertainment/get/all";
    }
}
