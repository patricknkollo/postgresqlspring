package com.forbes1.proj.services;

import com.forbes1.proj.entities.Person;
import com.forbes1.proj.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepository repository;

    //@Cacheable
    public ResponseEntity<List<Person>> getAllEmployeurs(){
        logger.info("this is from the database !!!");
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Person>> getAllEmployeursByCountry(String country){
        logger.info("this is from the database !!!");
        return new ResponseEntity<>(repository.findPersonByCountry(country), HttpStatus.OK);
    }

    public ResponseEntity<List<Person>> getAllTopTenEmployeurs(){
        logger.info("this is from the database !!!");
        return new ResponseEntity<>(repository.findTopTen(), HttpStatus.OK);
    }

    public ResponseEntity<List<Person>> getAllAfricansBillionaires(){
        logger.info("this is from the database !!!");
        return new ResponseEntity<>(repository.selectAfrica(), HttpStatus.OK);
    }
}
