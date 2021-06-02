package edu.coursework.hotel.repository;

import edu.coursework.hotel.model.Booking;
import edu.coursework.hotel.model.Corps;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
}
