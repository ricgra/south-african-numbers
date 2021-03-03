package com.ricgra.app.controller;

import com.ricgra.app.entity.PhoneNumberEntity;
import com.ricgra.app.model.ValidationStatus;
import com.ricgra.app.model.rest.PhoneNumberOutput;
import com.ricgra.app.model.rest.ValidationOutput;
import com.ricgra.app.repository.DatabaseStoreRepository;
import com.ricgra.app.utils.MockUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhoneNumberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    DatabaseStoreRepository databaseStoreRepository;

    private final String BASE_URL = "http://localhost:";

    @Test
    public void shouldValidatePhoneNumberREST() {
        ResponseEntity<ValidationOutput> response = restTemplate.getForEntity(BASE_URL + port
                        + "/rest/phone-number/27811234567/validate", ValidationOutput.class);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
        Assertions.assertEquals(response.getBody().isValid(), true);
    }

    @Test
    public void shouldNotValidatePhoneNumberForInputWithCharsREST() {
        ResponseEntity<ValidationOutput> response = restTemplate.getForEntity(BASE_URL + port
                        + "/rest/phone-number/DELETED_811234567/validate",
                ValidationOutput.class);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
        Assertions.assertEquals(response.getBody().isValid(), false);
        Assertions.assertEquals(response.getBody().getMessage(), ValidationStatus.INCORRECT_CONTAINS_CHARS.getReason());
    }

    @Test
    public void shouldDownloadOneRecordAsJSON() {
        mockDatabaseStoreRepositoryFindAll(MockUtils.getPhoneNumberEntities());

        ResponseEntity<PhoneNumberOutput> response = restTemplate.getForEntity(BASE_URL + port + "/rest/phone-number",
                PhoneNumberOutput.class);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
        Assertions.assertEquals(response.getBody().getCount(), 1);
        Assertions.assertEquals(response.getBody().getPhoneNumbers().size(), 1);
    }

    private void mockDatabaseStoreRepositoryFindAll(List<PhoneNumberEntity> phoneNumberEntities) {
        Mockito.when(databaseStoreRepository.findAll()).thenReturn(phoneNumberEntities);
    }

}
