package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Corps;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CorpsRepository extends MongoRepository<Corps, String> {
}
