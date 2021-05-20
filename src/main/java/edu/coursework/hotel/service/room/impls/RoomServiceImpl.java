package edu.coursework.hotel.service.room.impls;

import edu.coursework.hotel.model.Room;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.RoomRepository;
import edu.coursework.hotel.service.room.interfaces.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    RoomRepository repository;
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
}
