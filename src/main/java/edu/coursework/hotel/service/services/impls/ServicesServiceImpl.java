package edu.coursework.hotel.service.services.impls;

/*
    @author:    Slava
    @project:    Hotel
    @class:    ServicesServiceImpl
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Services;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.ServicesRepository;
import edu.coursework.hotel.service.services.interfaces.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServicesServiceImpl implements IServicesService {

    @Autowired
    ServicesRepository repository;
    @Override
    public Services getById(String id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public Services create(Services services) {
        services.setCreated_at(new Date());
        return repository.save(services);
    }

    @Override
    public Services update(Services services) {
        services.setModified_at(new Date());
        return repository.save(services);
    }

    @Override
    public Services delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Services> getAll() {
        return repository.findAll();
    }
}
