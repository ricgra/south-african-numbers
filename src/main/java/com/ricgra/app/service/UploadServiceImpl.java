package com.ricgra.app.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.exception.InvalidInputServiceException;
import com.ricgra.app.model.exception.NullInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    StoreService storeService;

    @Autowired
    ValidateService validateService;

    @Override
    public void uploadFile(InputStream inputFileStream) throws InvalidInputServiceException, NullInputServiceException {
        if(inputFileStream == null) {
            throw new NullInputServiceException("Input stream not valid, is null");
        }

        List<PhoneNumber> phoneNumberList = new ArrayList<>();

        try(CSVReader csvReader = parseInputStreamAsCSV(inputFileStream)) {
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                String id = row[0];
                String phoneNumber = row[1];

                // Validate and correct
                PhoneNumber validatedPhoneNumber = validateService.validateAndCorrect(id, phoneNumber);

                phoneNumberList.add(validatedPhoneNumber);
            }
        } catch (Exception e) {
            throw new InvalidInputServiceException("Input stream not valid");
        }

        // Store rows
        storeService.store(phoneNumberList);
    }

    private CSVReader parseInputStreamAsCSV(InputStream inputFileStream) {
        CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputFileStream))
                .withSkipLines(1)
                .build();

        return csvReader;
    }

}
