/*
package edu.coursework.hotel.data;

*/
/*
    @author:    Natalie
    @project:    Hotel
    @class:    FakeData
    @version:    1.0.0
    @since:    14.04.2021
*//*


import edu.coursework.hotel.model.Feedback;
import edu.coursework.hotel.model.Person;
import edu.coursework.hotel.model.Services;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FakeData {

    private List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person("1", "Igor", "Vits", 23),
                    new Person("2", "Grisha", "Vino", 18),
                    new Person("3", "Nick", "Bush", 26),
                    new Person("4", "Jhon", "Dush", 25),
                    new Person("5", "Julia", "Vits", 29),
                    new Person("6", "Natasha", "Leon", 30),
                    new Person("7", "Masha", "Mileno", 35),
                    new Person("8", "Oleg", "Lods", 40),
                    new Person("9", "Olga", "Zem", 23),
                    new Person("10", "Nina", "Lit", 40)));

    private List<Feedback> feedbackList = new ArrayList<>(
            Arrays.asList(
                    new Feedback("1", "Good", 5, personList.get(0)),
                    new Feedback("2", "Bad", 2, personList.get(1)),
                    new Feedback("3", "Good", 5, personList.get(2)),
                    new Feedback("4", "Nice", 4, personList.get(3)),
                    new Feedback("5", "Awesome", 7, personList.get(4)),
                    new Feedback("6", "Bad", 1, personList.get(5)),
                    new Feedback("7", "Nice", 3, personList.get(6)),
                    new Feedback("8", "Nice", 4, personList.get(7)),
                    new Feedback("9", "Awesome", 7, personList.get(8)),
                    new Feedback("10", "Good", 5, personList.get(9))));

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }
}
*/
