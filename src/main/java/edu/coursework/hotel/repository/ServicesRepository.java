package edu.coursework.hotel.repository;

/*
    @author:    Slava
    @project:    Hotel
    @class:    ServicesRepository
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Services;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends MongoRepository<Services, String> {
}
