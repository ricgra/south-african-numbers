package com.ricgra.app.util;

import com.ricgra.app.entity.PhoneNumberEntity;
import com.ricgra.app.model.PhoneNumber;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUtils {

    public static List<PhoneNumberEntity> mapPhoneNumberEntities(List<PhoneNumber> phoneNumbers) {
        return phoneNumbers.stream()
                .map(phoneNumber -> new PhoneNumberEntity(phoneNumber))
                .collect(Collectors.toList());
    }

    public static List<PhoneNumber> mapPhoneNumbers(List<PhoneNumberEntity> phoneNumberEntities) {
        return phoneNumberEntities.stream()
                .map(phoneNumberEntity -> new PhoneNumber(phoneNumberEntity))
                .collect(Collectors.toList());
    }

}
