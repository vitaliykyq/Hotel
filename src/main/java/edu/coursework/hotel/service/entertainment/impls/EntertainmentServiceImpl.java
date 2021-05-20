package edu.coursework.hotel.service.entertainment.impls;

import edu.coursework.hotel.model.Entertainment;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.EntertainmentRepository;
import edu.coursework.hotel.service.entertainment.interfaces.IEntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class EntertainmentServiceImpl implements IEntertainmentService {
    @Autowired
    EntertainmentRepository repository;
    @Override
    public Entertainment getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Entertainment create(Entertainment entertainment) {
        entertainment.setCreated_at(new Date());
        return repository.save(entertainment);
    }

    @Override
    public Entertainment update(Entertainment entertainment) {
        entertainment.setModified_at(new Date());
        return repository.save(entertainment);
    }

    @Override
    public Entertainment delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Entertainment> getAll() {
        return repository.findAll();
    }
}
