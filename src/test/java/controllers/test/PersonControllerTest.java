package controllers.test;

import com.forbes1.proj.controllers.PersonController;
import com.forbes1.proj.entities.Person;
import com.forbes1.proj.services.PersonService;
import net.sf.jasperreports.engine.JRException;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = {PersonControllerTest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonControllerTest {

    @InjectMocks
    private PersonController controller;

    @Mock
    private PersonService service;

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


    @Test
    void test_getAllEmployeurs(){
        ResponseEntity<List<Person>> expected = new ResponseEntity<>(Arrays.asList(person1, person2, person3), HttpStatus.OK);
        Mockito.when(service.getAllEmployeurs()).thenReturn(new ResponseEntity<>(Arrays.asList(person1, person2, person3), HttpStatus.OK));
        ResponseEntity<List<Person>> result = controller.getAllEmployeurs();
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    void test_getAllEmployeursByCountry(){
        ResponseEntity<List<Person>> expected = new ResponseEntity<>(Arrays.asList(person1, person2, person3), HttpStatus.OK);
        Mockito.when(service.getAllEmployeursByCountry("deutschland")).thenReturn(new ResponseEntity<>(Arrays.asList(person1, person2, person3), HttpStatus.OK));
        ResponseEntity<List<Person>> result = controller.getAllEmployeursByCountry("deutschland");
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    void test_getAllAfricansEmployeurs(){
        ResponseEntity<List<Person>> expected = new ResponseEntity<>(Arrays.asList(person1, person2, person3), HttpStatus.OK);
        Mockito.when(service.getAllAfricansBillionaires()).thenReturn(new ResponseEntity<>(Arrays.asList(person1, person2, person3), HttpStatus.OK));
        ResponseEntity<List<Person>> result = controller.getAllAfricansEmployeurs();
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }

    @Test
    void test_getAllFrobesReport() throws JRException, FileNotFoundException {
        byte[] bytes = {10,11};
        Mockito.when(service.getPersonReport()).thenReturn(new ResponseEntity<>(bytes, HttpStatus.OK));
        ResponseEntity<byte[]> result = controller.getAllFrobesReport();
        Assertions.assertEquals(bytes, result.getBody());
    }

    @Test
    void test_getAfricansFrobesReport() throws JRException, FileNotFoundException {
        byte[] bytes = {10,11};
        Mockito.when(service.getAfricansForbesReport()).thenReturn(new ResponseEntity<>(bytes, HttpStatus.OK));
        ResponseEntity<byte[]> result = controller.getAfricansFrobesReport();
        Assertions.assertEquals(bytes, result.getBody());
    }

    @Test
    void test_getTopTenFrobesReport() throws JRException, FileNotFoundException {
        byte[] bytes = {10,11};
        Mockito.when(service.getTopTenReport()).thenReturn(new ResponseEntity<>(bytes, HttpStatus.OK));
        ResponseEntity<byte[]> result = controller.getTopTenFrobesReport();
        Assertions.assertEquals(bytes, result.getBody());
    }
}
