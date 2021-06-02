package edu.coursework.hotel.service.feedback.impls;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    IServicesService
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.hotel.model.Feedback;
import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.FeedbackRepository;
import edu.coursework.hotel.repository.PersonRepository;
import edu.coursework.hotel.service.feedback.interfaces.IFeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    FeedbackRepository repository;
    @Autowired
    PersonRepository repositoryP;

    @Override
    public Feedback getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Feedback create(Feedback feedback) {

        feedback.setCreated_at(new Date());
        return repository.save(feedback);    }

    @Override
    public Feedback update(Feedback feedback) {
        feedback.setModified_at(new Date());
        String personID = feedback.getPerson().getId();
        Person person = repositoryP.findById(personID).orElse(null);
        feedback.setPerson(person);
        feedback.setCreated_at(repository.findById(feedback.getId())
                .orElse(null)
                .getCreated_at());
        repository.save(feedback);
        return feedback;
    }

    @Override
    public Feedback delete(String id) {

        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Feedback> getAll() {
        return repository.findAll();
    }
}
