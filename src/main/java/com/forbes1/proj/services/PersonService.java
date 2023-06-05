package com.forbes1.proj.services;

import com.forbes1.proj.entities.Person;
import com.forbes1.proj.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public ResponseEntity<List<Person>> getAllEmployeurs(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
