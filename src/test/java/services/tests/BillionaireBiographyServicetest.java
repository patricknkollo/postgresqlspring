package services.tests;


import com.forbes1.proj.entities.Biography;
import com.forbes1.proj.projections.DescriptedBillionaire;
import com.forbes1.proj.repositories.BillionaireBiographyRepository;
import com.forbes1.proj.services.BillionaireBiographyService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest(classes = PersonServiceTest.class )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BillionaireBiographyServicetest {

    @InjectMocks
    private BillionaireBiographyService service;

    @Mock
    private BillionaireBiographyRepository repository;

    private Biography biography = new Biography();
    private DescriptedBillionaire descriptedBillionaire = new DescriptedBillionaire();

    @BeforeEach
    void init(){
        biography.setBiography("my biography");
        biography.setNom("nkollo");
        biography.setPrenom("patrick");
        biography.setBiographyid(1);
        biography.setPersonid(1);
    }

    @Order(1)
    @Test
    void test_getBillionaireHistoryByBiographyID1(){
        ResponseEntity<Biography> expected = new ResponseEntity<>(biography, HttpStatus.OK);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(biography));
        ResponseEntity<Biography> result = service.getBillionaireHistoryByBiographyID(1);
        Assertions.assertEquals(expected, result);
    }

    @Order(2)
    @Test
    void test_getBillionaireHistoryByBiographyID2(){
        ResponseEntity<Biography> expected = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findById(1)).thenReturn(Optional.empty());
        ResponseEntity<Biography> result = service.getBillionaireHistoryByBiographyID(1);
        Assertions.assertEquals(expected, result);
    }

    @Order(3)
    @Test
    void test_getBillionaireHistoryByBllionaireID1(){
        ResponseEntity<DescriptedBillionaire> expected = new ResponseEntity<>(descriptedBillionaire, HttpStatus.OK);
        Mockito.when(repository.findBiographyByBillionaireid(1)).thenReturn(Optional.of(descriptedBillionaire));
        ResponseEntity<DescriptedBillionaire> result = service.getBillionaireHistoryByBllionaireID(1);
        Assertions.assertEquals(expected, result);
    }

    @Order(4)
    @Test
    void test_getBillionaireHistoryByBllionaireID2(){
        ResponseEntity<DescriptedBillionaire> expected = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        Mockito.when(repository.findById(1)).thenReturn(Optional.empty());
        ResponseEntity<DescriptedBillionaire> result = service.getBillionaireHistoryByBllionaireID(1);
        Assertions.assertEquals(expected, result);
    }
}
