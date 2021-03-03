package com.ricgra.app.service;

import com.opencsv.CSVWriter;
import com.ricgra.app.entity.PhoneNumberEntity;
import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.exception.CSVWriteServiceException;
import com.ricgra.app.repository.DatabaseStoreRepository;
import com.ricgra.app.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class DownloadServiceImpl implements DownloadService {

    private static final String CSV_HEADER_ID = "id";
    private static final String CSV_HEADER_SMS_PHONE = "sms_phone";
    private static final String CSV_HEADER_STATUS = "status";
    private static final String CSV_HEADER_REASON = "reason";

    @Autowired
    DatabaseStoreRepository databaseStoreRepository;

    @Override
    public void downloadAsCSV(PrintWriter writer) throws CSVWriteServiceException {
        try(CSVWriter csvWriter = new CSVWriter(writer)) {
            String[] csvHeaders = { CSV_HEADER_ID, CSV_HEADER_SMS_PHONE, CSV_HEADER_STATUS, CSV_HEADER_REASON };

            csvWriter.writeNext(csvHeaders);

            List<PhoneNumberEntity> phoneNumberList = databaseStoreRepository.findAll();

            for (PhoneNumberEntity phoneNumberEntity : phoneNumberList) {
                String[] phoneNumberCSV = getCSVPhoneNumberObj(phoneNumberEntity);

                csvWriter.writeNext(phoneNumberCSV);
            }
        } catch (IOException e) {
            throw new CSVWriteServiceException(e.getMessage());
        }
    }

    private String[] getCSVPhoneNumberObj(PhoneNumberEntity phoneNumberEntity) {
        return new String[]{
                            phoneNumberEntity.getId(),
                            phoneNumberEntity.getPhoneNumber(),
                            phoneNumberEntity.getStatus().toString(),
                            phoneNumberEntity.getReason()
                    };
    }

    @Override
    public List<PhoneNumber> download() {
        List<PhoneNumberEntity> phoneNumberList = databaseStoreRepository.findAll();

        return MapperUtils.mapPhoneNumbers(phoneNumberList);
    }

}
