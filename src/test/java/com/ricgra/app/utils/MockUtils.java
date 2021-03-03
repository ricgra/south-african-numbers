package com.ricgra.app.utils;

import com.ricgra.app.entity.PhoneNumberEntity;
import com.ricgra.app.model.ValidationStatus;

import java.util.ArrayList;
import java.util.List;

public class MockUtils {

    public static final String PHONE_NUMBER_ENTITY_MOCKED = "\"id\",\"sms_phone\",\"status\"," +
            "\"reason\"\n\"1\",\"27831234567\",\"ACCEPTED\",\"\"\n";

    public static List<PhoneNumberEntity> getPhoneNumberEntities() {
        List<PhoneNumberEntity> phoneNumberEntities = new ArrayList<>();
        PhoneNumberEntity phoneNumberEntity = new PhoneNumberEntity("1", "27831234567", ValidationStatus.ACCEPTED,
                "");
        phoneNumberEntities.add(phoneNumberEntity);

        return phoneNumberEntities;
    }

}
