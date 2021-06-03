package edu.coursework.hotel.repository;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    FeedbackRepository
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {
}
