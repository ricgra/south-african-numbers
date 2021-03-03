package com.ricgra.app.service;

import com.ricgra.app.model.exception.ErrorCode;
import com.ricgra.app.model.exception.InvalidInputServiceException;
import com.ricgra.app.model.exception.NullInputServiceException;
import com.ricgra.app.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class UploadServiceTest {

    @Autowired
    UploadService uploadService;

    @Test
    public void shouldUploadCSVFile() throws FileNotFoundException, InvalidInputServiceException, NullInputServiceException {
        InputStream in = FileUtils.getFileAsInputStream("south_african_mobile_numbers.csv");

        uploadService.uploadFile(in);
    }

    @Test
    public void shouldNotUploadNullCSVFile() {
        NullInputServiceException exception = Assertions.assertThrows(NullInputServiceException.class, () -> {
            InputStream in = null;

            uploadService.uploadFile(in);
        });

        Assertions.assertEquals(exception.getErrorCode(), ErrorCode.NULL_INPUT);
    }

    @Test
    public void shouldNotUploadPdfFile() {
        InvalidInputServiceException exception = Assertions.assertThrows(InvalidInputServiceException.class, () -> {
            InputStream in = FileUtils.getFileAsInputStream("not_valid_south_african_mobile_numbers.pdf");

            uploadService.uploadFile(in);
        });

        Assertions.assertEquals(exception.getErrorCode(), ErrorCode.INVALID_INPUT);
    }

}
