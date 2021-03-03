package com.ricgra.app.service;

import com.ricgra.app.entity.PhoneNumberEntity;
import com.ricgra.app.model.exception.CSVWriteServiceException;
import com.ricgra.app.repository.DatabaseStoreRepository;
import com.ricgra.app.utils.MockUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@SpringBootTest
public class DownloadServiceTest {

    @Autowired
    DownloadService downloadService;

    @MockBean
    DatabaseStoreRepository databaseStoreRepository;

    @Test
    public void shouldDownloadFile() {
        List<PhoneNumberEntity> phoneNumberEntities = MockUtils.getPhoneNumberEntities();

        mockDatabaseStoreRepositoryFindAll(phoneNumberEntities);

        Assertions.assertEquals(downloadService.download().size(), phoneNumberEntities.size());
        Assertions.assertEquals(downloadService.download().get(0).getId(), "1");
    }

    @Test
    public void shouldDownloadCSVFile() throws CSVWriteServiceException {
        mockDatabaseStoreRepositoryFindAll(MockUtils.getPhoneNumberEntities());

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        downloadService.downloadAsCSV(printWriter);

        Assertions.assertEquals(stringWriter.toString(), MockUtils.PHONE_NUMBER_ENTITY_MOCKED);
    }

    private void mockDatabaseStoreRepositoryFindAll(List<PhoneNumberEntity> phoneNumberEntities) {
        Mockito.when(databaseStoreRepository.findAll()).thenReturn(phoneNumberEntities);
    }

}
