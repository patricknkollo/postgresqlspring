package com.forbes1.proj.controllers;

import com.forbes1.proj.entities.Biography;
import com.forbes1.proj.services.BillionaireBiographyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class BillionairBiographyController {

    @Autowired
    private BillionaireBiographyService service;

    @ApiOperation(value = "This method is used to get the author name.")
    @RequestMapping(path = "/api/biography", method = RequestMethod.GET)
    public @ResponseBody  ResponseEntity<Biography> findBillionaireBiography(@RequestParam("id") Integer biographyid ){
        return service.getBillionaireHistoryByBiographyID(biographyid);
    }

    @RequestMapping(path = "/api/biography/billionaire", method = RequestMethod.GET)
    public @ResponseBody  ResponseEntity<Biography> findBillionaireBiographyByBillid(@RequestParam("id") Integer billionaireid ){
        return service.getBillionaireHistoryByBiographyID(billionaireid);
    }
}
