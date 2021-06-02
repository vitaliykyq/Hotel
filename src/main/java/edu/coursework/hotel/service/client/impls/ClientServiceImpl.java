package edu.coursework.hotel.service.client.impls;

import edu.coursework.hotel.model.Client;
import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.PersonRepository;
import edu.coursework.hotel.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    ClientRepository repository;

    @Autowired
    PersonRepository repositoryP;
    @Override
    public Client getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client create(Client client) {
        client.setCreated_at(new Date());
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        client.setModified_at(new Date());
        String personID = client.getPerson().getId();
        Person person = repositoryP.findById(personID).orElse(null);
        client.setPerson(person);
        client.setCreated_at(repository.findById(client.getId())
                .orElse(null)
                .getCreated_at());
        repository.save(client);
        return client;
    }

    @Override
    public Client delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }
}
