package com.ricgra.app.service;

import com.ricgra.app.entity.PhoneNumberEntity;
import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.repository.DatabaseStoreRepository;
import com.ricgra.app.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    DatabaseStoreRepository databaseStoreRepository;

    @Override
    public int store(List<PhoneNumber> phoneNumbers) {
        List<PhoneNumberEntity> phoneNumberEntities = MapperUtils.mapPhoneNumberEntities(phoneNumbers);

        List<PhoneNumberEntity> savedPhoneNumbers = databaseStoreRepository.saveAll(phoneNumberEntities);

        return savedPhoneNumbers.size();
    }

}
