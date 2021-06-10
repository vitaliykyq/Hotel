package edu.coursework.hotel.controller.ui;

/*
    @author:    Slava
    @project:    Hotel
    @class:    FeedbackUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.hotel.model.Feedback;
import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.service.feedback.impls.FeedbackServiceImpl;
import edu.coursework.hotel.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/feedback")
@Controller
public class FeedbackUIController {

    @Autowired
    FeedbackServiceImpl feedbackService;

    @Autowired
    PersonServiceImpl personService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Feedback> feedbackList = feedbackService.getAll();
        model.addAttribute("feedbackList", feedbackList);

        return "feedback/feedbackList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Feedback feedback = feedbackService.getById(id);
        model.addAttribute("feedback", feedback);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "feedback/updateFeedback";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("feedback") @RequestBody Feedback feedback) {

        feedbackService.update(feedback);
        return "redirect:/ui/feedback/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);

        List<Person> personIdList = personService.getAll();
        model.addAttribute("personIdList", personIdList);
        return "feedback/newFeedback";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("feedback") @RequestBody Feedback feedback) {

            feedback.setPerson(personService.getById(feedback.getPerson().getId()));
            model.addAttribute("feedback", feedbackService.create(feedback));
            return "redirect:/ui/feedback/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        feedbackService.delete(id);
        return "redirect:/ui/feedback/get/all";
    }
}
