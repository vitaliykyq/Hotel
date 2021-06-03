package edu.coursework.hotel.configuration;

/*
    @author:    Natalie
    @project:    Hotel
    @class:    MongoDBConfiguration
    @version:    1.0.0
    @since:    26.04.2021
*/

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoDBConfiguration extends AbstractMongoClientConfiguration {

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName(){
        return "hotel";
    }
}

