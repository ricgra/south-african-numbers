package com.ricgra.app.controller;

import com.ricgra.app.entity.PhoneNumberEntity;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CSVPhoneNumberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    DatabaseStoreRepository databaseStoreRepository;

    private final String BASE_URL = "http://localhost:";

    @Test
    public void shouldUploadPhoneNumbersFromCSVREST() throws FileNotFoundException {
        ClassPathResource uploadFile = new ClassPathResource("south_african_mobile_numbers.csv");

        HttpEntity<MultiValueMap<String, Object>> requestEntity = getUploadFile(uploadFile);

        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + port
                        + "/rest/phone-number/csv", HttpMethod.POST, requestEntity, String.class);

        Assertions.assertEquals(response.getStatusCodeValue(), 204);
    }

    @Test
    public void shouldDownloadPhoneNumbersAsCSVREST() {
        mockDatabaseStoreRepositoryFindAll(MockUtils.getPhoneNumberEntities());

        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + port
                + "/rest/phone-number/csv", String.class);

        Assertions.assertEquals(response.getStatusCodeValue(), 200);
        Assertions.assertEquals(response.getBody(), MockUtils.PHONE_NUMBER_ENTITY_MOCKED);
    }

    private void mockDatabaseStoreRepositoryFindAll(List<PhoneNumberEntity> phoneNumberEntities) {
        Mockito.when(databaseStoreRepository.findAll()).thenReturn(phoneNumberEntities);
    }

    private HttpEntity<MultiValueMap<String, Object>> getUploadFile(ClassPathResource uploadFile) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", uploadFile);

        return new HttpEntity<>(body, headers);
    }

}
