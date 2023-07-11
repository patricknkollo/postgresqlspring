package services.tests;


import com.forbes1.proj.entities.Person;
import com.forbes1.proj.repositories.PersonRepository;
import com.forbes1.proj.services.PersonService;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = PersonServiceTest.class )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService service;

    @Mock
    private PersonRepository repository;

    private Person person1 = new Person();
    private Person person2 = new Person();
    private Person person3 = new Person();

    @BeforeEach
    void setup(){
        person1.setAge(LocalDate.of(1989, 8,17));
        person1.setPrenom("patrick");
        person1.setNom("nkollo");
        person1.setPays("deuschland");
        person1.setPersonid(1);
        person1.setNetworth(330000000);
        person1.setUnite("euro");

        person2.setAge(LocalDate.of(1993, 5,6));
        person2.setPrenom("pierrette");
        person2.setNom("nkollo");
        person2.setPays("kamerun/deutschland");
        person2.setPersonid(2);
        person2.setNetworth(320000000);
        person2.setUnite("euro");

        person3.setAge(LocalDate.of(2023, 8,1));
        person3.setPrenom("elissa youyouu");
        person3.setNom("nkollo");
        person3.setPays("deuschland");
        person3.setPersonid(3);
        person3.setNetworth(310000000);
        person3.setUnite("euro");
    }

    @Order(1)
    @Test
    void test_getAllEmployeurs(){
        ResponseEntity<List<Person>> expected = new ResponseEntity<>(List.of(person1, person2, person3), HttpStatus.OK);
        Mockito.when(repository.findAll(ArgumentMatchers.isA(Sort.class))).thenReturn(List.of(person1, person2, person3));
        ResponseEntity<List<Person>> result = service.getAllEmployeurs();
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Order(2)
    @Test
    void test_getAllEmployeursByCountry(){
        List<Person>persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        ResponseEntity<List<Person>> expected = new ResponseEntity<>(persons, HttpStatus.OK);
        Mockito.when(repository.findPersonByCountry("deutschland")).thenReturn(persons);
        ResponseEntity<List<Person>> result = service.getAllEmployeursByCountry("deutschland");
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Order(3)
    @Test
    void test_getAllTopTenEmployeurs(){
        List<Person>persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        ResponseEntity<List<Person>> expected = new ResponseEntity<>(persons, HttpStatus.OK);
        Mockito.when(repository.findTopTen()).thenReturn(persons);
        ResponseEntity<List<Person>> result = service.getAllTopTenEmployeurs();
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Order(4)
    @Test
    void test_getAllAfricansBillionaires(){
        List<Person>persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person3);
        persons.add(person2);
        ResponseEntity<List<Person>> expected = new ResponseEntity<>(persons, HttpStatus.OK);
        Mockito.when(repository.selectAfrica()).thenReturn(persons);
        ResponseEntity<List<Person>> result = service.getAllAfricansBillionaires();
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }
}
