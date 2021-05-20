package edu.coursework.hotel.dao.feedback.impls;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    ServicesDAOImpl
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.dao.feedback.interfaces.IFeedbackDAO;
import edu.coursework.hotel.data.FakeData;
import edu.coursework.hotel.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class FeedbackDAOImpl implements IFeedbackDAO {

    @Autowired
    FakeData fakeData;

    /*@Override
    public Administration getById(String id) {
        return null;
    }

    @Override
    public Administration create(Administration administration) {
        return null;
    }

    @Override
    public Administration update(Administration administration) {
        return null;
    }

    @Override
    public Administration delete(String id) {
        return null;
    }

    @Override
    public Administration save(Administration administration) {
        return null;
    }

    @Override
    public List<Administration> getAll() {
        return fakeData.getAdministrations();
    }*/

    @Override
    public Feedback getById(String id) {
        return this.getAll().stream()
                .filter(feedback -> feedback.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Feedback create(Feedback feedback) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        feedback.setCreated_at(new Date());
        feedback.setId(id);
        this.getAll().add(feedback);
        return feedback;
    }

    @Override
    public Feedback update(Feedback feedback) {
        Feedback updatedFeedback = this.getById(feedback.getId());
        updatedFeedback.setResponse(feedback.getResponse());
        updatedFeedback.setStars(feedback.getStars());
        updatedFeedback.setPerson(feedback.getPerson());
        updatedFeedback.setModified_at(new Date());

        return updatedFeedback;

    }

    @Override
    public Feedback delete(String id) {
        Feedback feedback = this.getById(id);
        this.getAll().remove(feedback);
        return feedback;
    }

    @Override
    public Feedback save(Feedback feedback) {
        return null;
    }

    @Override
    public List<Feedback> getAll() {
        return fakeData.getFeedbackList();
    }
}
