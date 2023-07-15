/*

package controllers.test;

import com.forbes1.proj.ProjApplication;
import com.forbes1.proj.controllers.PersonController;
import com.forbes1.proj.entities.Person;
import com.forbes1.proj.services.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootTest(classes = ProjApplication.class)
@AutoConfigureMockMvc
public class PersonControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private PersonController controller;

    @Mock
    private PersonService service;

    private Person person1 = new Person();
    private Person person2 = new Person();
    private Person person3 = new Person();

    @BeforeEach
    void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

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
    void test_getAllEmployeurs() throws Exception {
         List<Person> persons = Arrays.asList(person1, person2, person3);
         ResponseEntity<List<Person>> responseEntity = new ResponseEntity<>(persons,  HttpStatus.OK);
       Mockito.when(service.getAllEmployeurs()).thenReturn(responseEntity);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/employeur/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].prenom", Matchers.is("pierrette"))
                );

    }
}

*/
