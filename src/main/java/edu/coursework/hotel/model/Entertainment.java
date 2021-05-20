package edu.coursework.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "entertainment")
public class Entertainment {
    @Id
    private String id;

    private String type;
    private int price;
    private int cost;

    private Date created_at;
    private Date modified_at;
    private String description;
}
