package edu.coursework.hotel.dao.person.interfaces;

/*
    @author:    Natalie
    @project:    Hotel
    @interface:    IServicesDAO
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.hotel.model.Person;

import java.util.List;

public interface IPersonDAO {

    Person getById(String id);
    Person create(Person person);
    Person update(Person person);
    Person delete(String id);
    Person save(Person person);
    List<Person> getAll();
}
