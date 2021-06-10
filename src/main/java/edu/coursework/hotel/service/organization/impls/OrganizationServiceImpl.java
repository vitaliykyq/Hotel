package edu.coursework.hotel.service.organization.impls;

/*
    @author:    Slava
    @project:    Hotel
    @class:    OrganizationServiceImpl
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Organization;
import edu.coursework.hotel.repository.ClientRepository;
import edu.coursework.hotel.repository.OrganizationRepository;
import edu.coursework.hotel.service.organization.interfaces.IOrganizationService;
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
public class OrganizationServiceImpl implements IOrganizationService {
    @Autowired
    OrganizationRepository repository;
    private final MongoTemplate mongoTemplate;
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

    public Object getNumOfOrganizations() {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.count().as("numberOfOrganizations"));

        return mongoTemplate.aggregate(aggregation, "organization", Object.class).getMappedResults();
    }

    public List<Organization> getAllByAmountGreaterThanEqual(int amount){
        return repository.findAllByAmountGreaterThanEqual(amount);
    }
}
