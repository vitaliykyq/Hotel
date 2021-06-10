package edu.coursework.hotel.repository;

/*
    @author:    Slava
    @project:    Hotel
    @class:    EntertainmentRepository
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Entertainment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntertainmentRepository extends MongoRepository<Entertainment, String> {
}
