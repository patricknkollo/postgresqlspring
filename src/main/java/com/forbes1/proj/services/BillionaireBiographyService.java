package com.forbes1.proj.services;

import com.forbes1.proj.entities.Biography;
import com.forbes1.proj.projections.DescriptedBillionaire;
import com.forbes1.proj.repositories.BillionaireBiographyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillionaireBiographyService {

    private Logger logger = LoggerFactory.getLogger(BillionaireBiographyService.class);

    private BillionaireBiographyRepository repository;
    @Autowired
    public BillionaireBiographyService (BillionaireBiographyRepository aRepository){
        this.repository=aRepository;
    }

    //primary C + RUD
    public ResponseEntity<Biography> getBillionaireHistoryByBiographyID(Integer id){
        Optional<Biography> optionalBillionaireBiography = repository.findById(id);
        ResponseEntity<Biography> responseEntity;
        if (optionalBillionaireBiography.isPresent()){
            logger.info("the Biography with the id {} exist in the database", id);
            responseEntity = new ResponseEntity<>(optionalBillionaireBiography.get(), HttpStatus.OK);
        }
        else {
            logger.warn("the Biography with the id {} doesn't exist in the database", id);
            responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    public ResponseEntity<DescriptedBillionaire> getBillionaireHistoryByBllionaireID(Integer id){
        Optional<DescriptedBillionaire> optionalBillionaireBiography = repository.findBiographyByBillionaireid(id);
        ResponseEntity<DescriptedBillionaire> responseEntity;
        if (optionalBillionaireBiography.isPresent()){
            logger.info("the Biography with the id {} exist in the database", id);
            responseEntity = new ResponseEntity<>(optionalBillionaireBiography.get(), HttpStatus.OK);
        }
        else {
            logger.warn("the Biography with the id {} doesn't exist in the database", id);
            responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
