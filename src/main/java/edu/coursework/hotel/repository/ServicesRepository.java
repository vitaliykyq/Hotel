package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Services;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicesRepository extends MongoRepository<Services, String> {
}
