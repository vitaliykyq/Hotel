package edu.coursework.hotel.service.booking.impls;

/*
    @author:    Slava
    @project:    Hotel
    @class:    BookingServiceImpl
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Booking;
import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.repository.BookingRepository;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.FeedbackRepository;
import edu.coursework.hotel.repository.PersonRepository;
import edu.coursework.hotel.service.booking.interfaces.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Fields.fields;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService {

    @Autowired
    BookingRepository repository;
    @Autowired
    ClientRepository repositoryC;
    private final MongoTemplate mongoTemplate;
    @Override
    public Booking getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Booking create(Booking booking) {
        booking.setCreated_at(new Date());
        return repository.save(booking);    }


    @Override
    public Booking update(Booking booking) {
        booking.setModified_at(new Date());
        String clientID = booking.getClient().getId();
        Client client= repositoryC.findById(clientID).orElse(null);
        booking.setClient(client);
        booking.setCreated_at(repository.findById(booking.getId())
                .orElse(null)
                .getCreated_at());
        repository.save(booking);
        return booking;
    }

    @Override
    public Booking delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Booking> getAll() {
        return repository.findAll();
    }

    public Object getRoomWithDateOfEviction(String eviction) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("eviction").is(eviction).and("room.isFree").is(false)));
        return mongoTemplate.aggregate(aggregation, "booking", Object.class).getMappedResults();
    }
}
