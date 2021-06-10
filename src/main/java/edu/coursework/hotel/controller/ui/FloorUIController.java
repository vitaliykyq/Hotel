package edu.coursework.hotel.controller.ui;

/*
    @author:    Slava
    @project:    Hotel
    @class:    FloorUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.floor.impls.FloorServiceImpl;
import edu.coursework.hotel.service.person.impls.PersonServiceImpl;
import edu.coursework.hotel.service.room.impls.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/floor")
@Controller
public class FloorUIController {

    @Autowired
    FloorServiceImpl floorService;

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    RoomServiceImpl roomService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Floor> floorList = floorService.getAll();
        model.addAttribute("floorList", floorList);

        return "floor/floorList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Floor floor = floorService.getById(id);
        model.addAttribute("floor", floor);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<Room> roomListId = roomService.getAll();
        model.addAttribute("roomListId", roomListId);
        return "floor/updateFloor";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("floor") @RequestBody  Floor floor ) {

        floorService.update(floor);
        return "redirect:/ui/floor/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Floor floor  = new Floor();
        model.addAttribute("floor", floor);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<Room> roomListId = roomService.getAll();
        model.addAttribute("roomListId", roomListId);
        return "floor/newFloor";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("floor") @RequestBody Floor floor) {
        model.addAttribute("floor", floorService.create(floor));
        return "redirect:/ui/floor/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        floorService.delete(id);
        return "redirect:/ui/floor/get/all";
    }
}
