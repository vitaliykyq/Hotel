package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import edu.coursework.hotel.model.object.objBooking;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "client")
public class Client {
@Id
    private String id;

    private Person person;
    private objBooking booking;

    private Date created_at;
    private Date modified_at;
    private String description;
}
