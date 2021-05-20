package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
}
