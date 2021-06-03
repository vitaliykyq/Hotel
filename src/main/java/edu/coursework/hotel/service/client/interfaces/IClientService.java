package edu.coursework.hotel.service.client.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    IClientService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Booking;
import edu.coursework.hotel.model.Client;

import java.util.List;

public interface IClientService {

    Client getById(String id);
    Client create(Client client);
    Client update(Client client);
    Client delete(String id);
    List<Client> getAll();
}
