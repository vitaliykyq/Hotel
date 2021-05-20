package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Entertainment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntertainmentRepository extends MongoRepository<Entertainment, String> {
}
