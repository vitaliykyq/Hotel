package edu.coursework.hotel.controller.ui;

/*
    @author:    Slava
    @project:    Hotel
    @class:    CorpsUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.corps.impls.CorpsServiceImpl;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.floor.impls.FloorServiceImpl;
import edu.coursework.hotel.service.room.impls.RoomServiceImpl;
import edu.coursework.hotel.service.services.impls.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/corps")
@Controller
public class CorpsUIController {

    @Autowired
    CorpsServiceImpl corpsService;

    @Autowired
    FloorServiceImpl floorService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Corps> corpsList = corpsService.getAll();
        model.addAttribute("corpsList", corpsList);

        return "corps/corpsList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Corps corps = corpsService.getById(id);
        model.addAttribute("corps", corps);

        List<Floor> floorListId = floorService.getAll();
        model.addAttribute("floorListId", floorListId);
        return "corps/updateCorps";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("corps") @RequestBody  Corps corps ) {

        corpsService.update(corps);
        return "redirect:/ui/corps/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Corps corps  = new Corps();
        model.addAttribute("corps", corps);

        List<Floor> floorListId = floorService.getAll();
        model.addAttribute("floorListId", floorListId);
        return "corps/newCorps";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("corps") @RequestBody Corps corps) {
        model.addAttribute("feedback", corpsService.create(corps));
        return "redirect:/ui/corps/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        corpsService.delete(id);
        return "redirect:/ui/corps/get/all";
    }
}
