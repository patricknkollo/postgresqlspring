package controllers.test;

import com.forbes1.proj.controllers.BillionairBiographyController;
import com.forbes1.proj.entities.Biography;
import com.forbes1.proj.services.BillionaireBiographyService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = BillionaireBiographyControllerTest.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BillionaireBiographyControllerTest {

    @InjectMocks
    private BillionairBiographyController controller;

    @Mock
    private BillionaireBiographyService service;

    private Biography biography = new Biography();

    @BeforeEach
    void init(){
        biography.setBiography("my biography");
        biography.setBiographyid(3);
        biography.setNom("nkollo");
        biography.setPrenom("elissa");
        biography.setPersonid(7);
    }

    @Test
    @Order(1)
    void test_findBillionaireBiography(){
        Mockito.when(service.getBillionaireHistoryByBiographyID(1)).thenReturn(new ResponseEntity<>(biography, HttpStatus.OK));
        ResponseEntity<Biography> result = controller.findBillionaireBiography(1);
        Assertions.assertEquals(result.getBody(), biography);
    }

    @Test
    @Order(2)
   void test_findBillionaireBiographyByBillid(){
        Mockito.when(service.getBillionaireHistoryByBiographyID(1)).thenReturn(new ResponseEntity<>(biography, HttpStatus.OK));
        ResponseEntity<Biography> result = controller.findBillionaireBiographyByBillid(1);
        Assertions.assertEquals(result.getBody(), biography);
    }
}
