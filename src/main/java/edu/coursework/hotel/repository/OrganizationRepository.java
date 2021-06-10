package edu.coursework.hotel.repository;

/*
    @author:    Slava
    @project:    Hotel
    @class:    OrganizationRepository
    @version:    1.0.0
    @since:    26.04.2021
*/

import edu.coursework.hotel.model.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, String> {
    public List<Organization> findAllByAmountGreaterThanEqual (int amount) ;


}
