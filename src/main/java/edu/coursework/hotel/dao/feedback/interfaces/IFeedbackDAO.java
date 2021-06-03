package edu.coursework.hotel.dao.feedback.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @interface:    IFeedbackDAO
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Feedback;

import java.util.List;

public interface IFeedbackDAO {

    Feedback getById(String id);
    Feedback create(Feedback feedback);
    Feedback update(Feedback feedback);
    Feedback delete(String id);
    Feedback save(Feedback feedback);
    List<Feedback> getAll();
}
