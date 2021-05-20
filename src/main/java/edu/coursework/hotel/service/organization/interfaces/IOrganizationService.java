package edu.coursework.hotel.service.organization.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    IServicesService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Floor;
import edu.coursework.hotel.model.Organization;

import java.util.List;

public interface IOrganizationService {

    Organization getById(String id);
    Organization create(Organization organization);
    Organization update(Organization organization);
    Organization delete(String id);
    List<Organization> getAll();
}
