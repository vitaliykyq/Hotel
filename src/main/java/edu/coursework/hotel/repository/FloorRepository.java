package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Floor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FloorRepository extends MongoRepository<Floor, String> {
}
