package edu.coursework.hotel.service.room.impls;

/*
    @author:    Slava
    @project:    Hotel
    @class:    RoomServiceImpl
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Room;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.RoomRepository;
import edu.coursework.hotel.service.room.interfaces.IRoomService;
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
public class RoomServiceImpl implements IRoomService {
    @Autowired
    RoomRepository repository;
    private final MongoTemplate mongoTemplate;
    @Override
    public Room getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Room create(Room room) {
        room.setCreated_at(new Date());
        return repository.save(room);
    }

    @Override
    public Room update(Room room) {
        room.setModified_at(new Date());
        return repository.save(room);
    }

    @Override
    public Room delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Room> getAll() {
        return repository.findAll();

    }
    public Object getFreeRooms() {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("isFree").is(true)),
                Aggregation.group(fields().and("isFree")).count().as("numOfFreeRooms"));

        return mongoTemplate.aggregate(aggregation, "room", Object.class).getMappedResults();
    }

    public Object getFreeRoomsByCapacity(int capacity) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("isFree").is(true).and("capacity").is(capacity)),
                Aggregation.group(fields().and("isFree")).count().as("numOfFreeRooms"),
                Aggregation.project("numOfFreeRooms", "capacity"));

        return mongoTemplate.aggregate(aggregation, "room", Object.class).getMappedResults();
    }
    public Object getFreeRoomsByPriceIn(int minPrice, int maxPrice ) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("isFree").is(true).and("price").gte(minPrice).lte(maxPrice)),
                Aggregation.group(fields().and("isFree")).count().as("numOfFreeRooms"));

        return mongoTemplate.aggregate(aggregation, "room", Object.class).getMappedResults();
    }

    public Object getFreeRoomByNumber(int number ) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("isFree").is(true).and("number").is(number)));

        return mongoTemplate.aggregate(aggregation, "room", Object.class).getMappedResults();
    }
}
