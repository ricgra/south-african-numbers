package com.ricgra.app.service;

import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.ValidationStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StoreServiceTest {

    @Autowired
    private StoreService storeService;

    @Test
    public void shouldStoreData() {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber("1", "27831234567", ValidationStatus.ACCEPTED));
        phoneNumberList.add(new PhoneNumber("1", "831234567", ValidationStatus.CORRECTED_PREFIX));

        Assertions.assertEquals(storeService.store(phoneNumberList), 2);
    }

    @Test
    public void shouldNotStoreData() {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber("1", "27831234567", null));

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> storeService.store(phoneNumberList));
    }

}
