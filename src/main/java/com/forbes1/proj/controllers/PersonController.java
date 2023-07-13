package com.forbes1.proj.controllers;

import com.forbes1.proj.entities.Person;
import com.forbes1.proj.services.PersonService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping(path = "/api/employeur" , produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping(path = "/all/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getAllFrobesReport() throws JRException, FileNotFoundException {
        return service.getPersonReport();
    }

    @RequestMapping(path = "/africans/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getAfricansFrobesReport() throws JRException, FileNotFoundException {
        return service.getAfricansForbesReport();
    }

    @RequestMapping(path = "/topten/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getTopTenFrobesReport() throws JRException, FileNotFoundException {
        return service.getTopTenReport();
    }
}
