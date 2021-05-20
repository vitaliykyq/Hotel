package edu.coursework.hotel.service.organization.impls;

import edu.coursework.hotel.model.Organization;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.OrganizationRepository;
import edu.coursework.hotel.service.organization.interfaces.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrganizationServiceImpl implements IOrganizationService {
    @Autowired
    OrganizationRepository repository;
    @Override
    public Organization getById(String id) {
        return repository.findById(id).orElse(null);}

    @Override
    public Organization create(Organization organization) {

        organization.setCreated_at(new Date());
        return repository.save(organization);
    }

    @Override
    public Organization update(Organization organization) {

        organization.setModified_at(new Date());
        return repository.save(organization);
    }

    @Override
    public Organization delete(String id) {

        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Organization> getAll() {
        return repository.findAll();
    }
}
