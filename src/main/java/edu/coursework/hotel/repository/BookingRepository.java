package edu.coursework.hotel.repository;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    BookingRepository
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
}
