package com.forbes1.proj.services;

import com.forbes1.proj.entities.Person;
import com.forbes1.proj.entities.PersonWithIntAge;
import com.forbes1.proj.repositories.PersonRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepository repository;

    @Cacheable("person")
    public ResponseEntity<List<Person>> getAllEmployeurs(){
        logger.info("this is from the database !!!");
        return new ResponseEntity<>(repository.findAll(Sort.by(Sort.Direction.DESC, "networth")), HttpStatus.OK);
    }

    public ResponseEntity<List<Person>> getAllEmployeursByCountry(String country){
        logger.info("this is from the database !!!");
        List<Person> persons = repository.findPersonByCountry(country);
        persons.sort(Comparator.comparing(Person::getNetworth, Comparator.reverseOrder()));
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    public ResponseEntity<List<Person>> getAllTopTenEmployeurs(){
        logger.info("this is from the database !!!");
        List<Person> persons = repository.findTopTen();
        persons.sort(Comparator.comparing(Person::getNetworth, Comparator.reverseOrder()));
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    public ResponseEntity<List<Person>> getAllAfricansBillionaires(){
        logger.info("this is from the database !!!");
        List<Person> persons = repository.selectAfrica();
        persons.sort(Comparator.comparing(Person::getNetworth, Comparator.reverseOrder()));
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    public ResponseEntity<byte[]> getPersonReport2() throws FileNotFoundException, JRException {
        List<Person>billionaires = repository.findAll(Sort.by(Sort.Direction.ASC, "personid"));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(billionaires);
        Map<String, Object> empParams = new HashMap<>();
        JasperPrint empReport =
                JasperFillManager.fillReport
                        (
                                JasperCompileManager.compileReport(
                                        ResourceUtils.getFile("classpath:jasperreports/billionaires.jrxml")
                                                .getAbsolutePath()) // path of the jasper report
                                , empParams // dynamic parameters
                                , dataSource
                        );
        HttpHeaders headers = new HttpHeaders();
        //set the PDF format
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "forbes.pdf");
        //create the report in PDF format
        return new ResponseEntity<byte[]>
                (JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
    }

    public ResponseEntity<byte[]> getPersonReport() throws FileNotFoundException, JRException {
        List<PersonWithIntAge> billionairesWithIntAge = new ArrayList<>();
        List<Person>billionaires = repository.findAll(Sort.by(Sort.Direction.ASC, "personid"));
        billionaires.forEach(
                billionaire ->{
                    PersonWithIntAge personWithIntAge = new PersonWithIntAge();
                    personWithIntAge.setAge(String.valueOf(Period.between(billionaire.getAge(), LocalDate.now()).getYears()));
                    personWithIntAge.setNom(billionaire.getNom());
                    personWithIntAge.setPays(billionaire.getPays());
                    personWithIntAge.setPrenom(billionaire.getPrenom());
                    personWithIntAge.setPersonid(billionaire.getPersonid());
                    personWithIntAge.setNetworth(billionaire.getNetworth());
                    personWithIntAge.setUnite(billionaire.getUnite());

                    billionairesWithIntAge.add(personWithIntAge);
                }
        );
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(billionairesWithIntAge);
        Map<String, Object> empParams = new HashMap<>();
        JasperPrint empReport =
                JasperFillManager.fillReport
                        (
                                JasperCompileManager.compileReport(
                                        ResourceUtils.getFile("classpath:jasperreports/billionaires.jrxml")
                                                .getAbsolutePath()) // path of the jasper report
                                , empParams // dynamic parameters
                                , dataSource
                        );
        HttpHeaders headers = new HttpHeaders();
        //set the PDF format
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "forbes.pdf");
        //create the report in PDF format
        return new ResponseEntity<byte[]>
                (JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
    }

    public ResponseEntity<byte[]> getTopTenReport() throws FileNotFoundException, JRException {
        List<PersonWithIntAge> billionairesWithIntAge = new ArrayList<>();
        List<Person>billionaires = repository.findTopTen();
        billionaires.forEach(
                billionaire ->{
                    PersonWithIntAge personWithIntAge = new PersonWithIntAge();
                    personWithIntAge.setAge(String.valueOf(Period.between(billionaire.getAge(), LocalDate.now()).getYears()));
                    personWithIntAge.setNom(billionaire.getNom());
                    personWithIntAge.setPays(billionaire.getPays());
                    personWithIntAge.setPrenom(billionaire.getPrenom());
                    personWithIntAge.setPersonid(billionaire.getPersonid());
                    personWithIntAge.setNetworth(billionaire.getNetworth());
                    personWithIntAge.setUnite(billionaire.getUnite());

                    billionairesWithIntAge.add(personWithIntAge);
                }
        );
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(billionairesWithIntAge);
        Map<String, Object> empParams = new HashMap<>();
        JasperPrint empReport =
                JasperFillManager.fillReport
                        (
                                JasperCompileManager.compileReport(
                                        ResourceUtils.getFile("classpath:jasperreports/billionaires.jrxml")
                                                .getAbsolutePath()) // path of the jasper report
                                , empParams // dynamic parameters
                                , dataSource
                        );
        HttpHeaders headers = new HttpHeaders();
        //set the PDF format
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "forbes.pdf");
        //create the report in PDF format
        return new ResponseEntity<byte[]>
                (JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
    }

    public ResponseEntity<byte[]> getAfricansForbesReport() throws FileNotFoundException, JRException {
        List<PersonWithIntAge> billionairesWithIntAge = new ArrayList<>();
        List<Person>billionaires = repository.selectAfrica();
        billionaires.forEach(
                billionaire ->{
                    PersonWithIntAge personWithIntAge = new PersonWithIntAge();
                    personWithIntAge.setAge(String.valueOf(Period.between(billionaire.getAge(), LocalDate.now()).getYears()));
                    personWithIntAge.setNom(billionaire.getNom());
                    personWithIntAge.setPays(billionaire.getPays());
                    personWithIntAge.setPrenom(billionaire.getPrenom());
                    personWithIntAge.setPersonid(billionaire.getPersonid());
                    personWithIntAge.setNetworth(billionaire.getNetworth());
                    personWithIntAge.setUnite(billionaire.getUnite());

                    billionairesWithIntAge.add(personWithIntAge);
                }
        );
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(billionairesWithIntAge);
        Map<String, Object> empParams = new HashMap<>();
        JasperPrint empReport =
                JasperFillManager.fillReport
                        (
                                JasperCompileManager.compileReport(
                                        ResourceUtils.getFile("classpath:jasperreports/billionaires.jrxml")
                                                .getAbsolutePath()) // path of the jasper report
                                , empParams // dynamic parameters
                                , dataSource
                        );
        HttpHeaders headers = new HttpHeaders();
        //set the PDF format
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "forbes.pdf");
        //create the report in PDF format
        return new ResponseEntity<byte[]>
                (JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
    }

  /*  //@Override
    public void resolveResources(ResourceLoader loader) throws IOException, JRException {
       // Map<String, Object> map = super.getParams();
        Map<String, Object> map = new HashMap<>();
        Map.of(
                        "EXECUTEMAIN_REPORT", "classpath:templates/orderpackage/orderpackageexecutemain.jrxml",
                        "HINT_REPORT", "classpath:templates/orderpackage/orderpackagehint.jrxml",
                        "KW_REPORT", "classpath:templates/orderpackage/orderpackagekw.jrxml",
                        "PART_REPORT", "classpath:templates/orderpackage/orderpackagepart.jrxml",
                        "HINT_OVERVIEW_REPORT",
                        "classpath:templates/orderpackage/orderpackagehintoverview.jrxml")
                .forEach((key, value) -> PrinterUtil.addParamFromPath(loader, key, value, map));
        try (InputStream jrxml = loader
                .getResource("classpath:templates/orderpackage/orderpackage.jrxml").getInputStream()) {
            super.setReport(JasperCompileManager.compileReport(jrxml));
        }
    }*/
}
