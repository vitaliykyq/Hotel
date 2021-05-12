package edu.coursework.hotel.service.feedback.impls;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    IServicesService
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.hotel.dao.feedback.impls.FeedbackDAOImpl;
import edu.coursework.hotel.data.FakeData;
import edu.coursework.hotel.model.Feedback;
import edu.coursework.hotel.service.feedback.interfaces.IFeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    FakeData fakeData;

    @Autowired
    FeedbackDAOImpl dao;

    @Override
    public Feedback getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Feedback create(Feedback feedback) {
        return dao.create(feedback);
    }

    @Override
    public Feedback update(Feedback feedback) {
        return dao.update(feedback);
    }

    @Override
    public Feedback delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Feedback save(Feedback feedback) {
        return null;
    }

    @Override
    public List<Feedback> getAll() {
        return dao.getAll();
    }
}
