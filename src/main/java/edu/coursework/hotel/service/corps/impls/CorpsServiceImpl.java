package edu.coursework.hotel.service.corps.impls;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    CorpsServiceImpl
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Corps;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.CorpsRepository;
import edu.coursework.hotel.service.corps.interfaces.ICorpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CorpsServiceImpl implements ICorpsService {

    @Autowired
    CorpsRepository repository;
    @Override
    public Corps getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Corps create(Corps corps) {

        corps.setCreated_at(new Date());
        return repository.save(corps);
    }

    @Override
    public Corps update(Corps corps) {

        corps.setModified_at(new Date());
        return repository.save(corps);
    }

    @Override
    public Corps delete(String id) {
        repository.deleteById(id);
        return null;    }

    @Override
    public List<Corps> getAll() {
        return repository.findAll();
    }
}
