package com.forbes1.proj.controllers;

import com.forbes1.proj.entities.Person;
import com.forbes1.proj.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api/employeur")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> getAllEmployeurs(){
        return service.getAllEmployeurs();
    }
}
