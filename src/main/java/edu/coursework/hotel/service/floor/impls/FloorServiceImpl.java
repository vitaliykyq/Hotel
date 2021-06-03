package edu.coursework.hotel.service.floor.impls;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    FloorServiceImpl
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Floor;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.FloorRepository;
import edu.coursework.hotel.service.floor.interfaces.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FloorServiceImpl implements IFloorService {
    @Autowired
    FloorRepository repository;
    @Override
    public Floor getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Floor create(Floor floor) {

        floor.setCreated_at(new Date());
        return repository.save(floor);
    }

    @Override
    public Floor update(Floor floor) {

        floor.setModified_at(new Date());
        return repository.save(floor);
    }

    @Override
    public Floor delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Floor> getAll() {
        return repository.findAll();
    }
}
