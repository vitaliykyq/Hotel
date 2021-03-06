package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String id;

    private String name;
    private String surname;
    private int age;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Person(String id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        created_at = LocalDateTime.now();
    }
}
