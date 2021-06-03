package edu.coursework.hotel.service.feedback.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    IFeedbackService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Feedback;

import java.util.List;

public interface IFeedbackService {

    Feedback getById(String id);
    Feedback create(Feedback feedback);
    Feedback update(Feedback feedback);
    Feedback delete(String id);
    List<Feedback> getAll();
}
