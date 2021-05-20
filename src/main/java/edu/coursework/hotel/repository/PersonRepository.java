package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
