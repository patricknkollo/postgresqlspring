package com.forbes1.proj.controllers;

import com.forbes1.proj.entities.Person;
import com.forbes1.proj.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/employeur")
@CrossOrigin
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> getAllEmployeurs(){
        return service.getAllEmployeurs();
    }

    @RequestMapping(path = "/all/{country}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> getAllEmployeursByCountry(@PathVariable("country") String pays){
        return service.getAllEmployeursByCountry(pays);
    }

    @RequestMapping(path = "/topten", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> getAllTopTenBillionaires(){
        return service.getAllTopTenEmployeurs();
    }

    @RequestMapping(path = "/africans", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> getAllAfricansEmployeurs(){
        return service.getAllAfricansBillionaires();
    }
}
