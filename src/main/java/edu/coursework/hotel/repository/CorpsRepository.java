package edu.coursework.hotel.repository;

/*
    @author:    Slava
    @project:    Hotel
    @class:    CorpsRepository
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Corps;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpsRepository extends MongoRepository<Corps, String> {
}
