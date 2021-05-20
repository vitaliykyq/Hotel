package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
