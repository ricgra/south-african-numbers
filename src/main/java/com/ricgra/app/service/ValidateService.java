package com.ricgra.app.service;

import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.ValidationStatus;
import org.apache.commons.lang3.StringUtils;

public interface ValidateService {

    default ValidationStatus validate(String id, String phoneNumber) {
        if(StringUtils.isEmpty(id)) {
            return ValidationStatus.INCORRECT_EMPTY_ID;
        }

        return validatePhoneNumber(phoneNumber);
    }

    ValidationStatus validatePhoneNumber(String phoneNumber);

    PhoneNumber validateAndCorrect(String id, String phoneNumber);

    boolean isValid(ValidationStatus validationStatus);

}
