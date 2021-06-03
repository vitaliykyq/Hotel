package edu.coursework.hotel.controller.ui;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    RoomUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.*;
import edu.coursework.hotel.service.entertainment.impls.EntertainmentServiceImpl;
import edu.coursework.hotel.service.room.impls.RoomServiceImpl;
import edu.coursework.hotel.service.services.impls.ServicesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/room")
@Controller
public class RoomUIController {

    @Autowired
    RoomServiceImpl roomService;

    @Autowired
    EntertainmentServiceImpl entertainmentService;

    @Autowired
    ServicesServiceImpl servicesService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Room> roomList = roomService.getAll();
        model.addAttribute("roomList", roomList);

        return "room/roomList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Room room = roomService.getById(id);
        model.addAttribute("room", room);

        List<Entertainment> entertainmentListId = entertainmentService.getAll();
        model.addAttribute("entertainmentListId", entertainmentListId);

        List<Services> servicesListId = servicesService.getAll();
        model.addAttribute("servicesListId", servicesListId);
        return "room/updateRoom";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("room") @RequestBody  Room room ) {

        roomService.update(room);
        return "redirect:/ui/room/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Room room = new Room();
        model.addAttribute("room", room);

        List<Entertainment> entertainmentListId = entertainmentService.getAll();
        model.addAttribute("entertainmentListId", entertainmentListId);

        List<Services> servicesListId = servicesService.getAll();
        model.addAttribute("servicesListId", servicesListId);
        return "room/newRoom";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("room") @RequestBody Room room) {
        model.addAttribute("room", roomService.create(room));
        return "redirect:/ui/room/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        roomService.delete(id);
        return "redirect:/ui/room/get/all";
    }
}
