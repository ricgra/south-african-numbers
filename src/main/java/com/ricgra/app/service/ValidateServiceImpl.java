package com.ricgra.app.service;

import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.ValidationStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidateServiceImpl implements ValidateService {

    private static final String PHONE_NUMBER_PREFIX = "27";
    private static final String REGEX_NUMBERS = "[0-9]+";

    @Override
    public ValidationStatus validatePhoneNumber(String phoneNumber) {
        if(StringUtils.isEmpty(phoneNumber)) {
            return ValidationStatus.INCORRECT_EMPTY_PHONE_NUMBER;
        }

        if(!phoneNumber.matches(REGEX_NUMBERS)) {
            return ValidationStatus.INCORRECT_CONTAINS_CHARS;
        }

        if(phoneNumber.length() != 9 && phoneNumber.length() != 11) {
            return ValidationStatus.INCORRECT_PHONE_NUMBER_LENGHT;
        }

        if(!phoneNumber.startsWith(PHONE_NUMBER_PREFIX)) {
            if(phoneNumber.length() == 9) {
                return ValidationStatus.CORRECTED_PREFIX;
            }

            return ValidationStatus.INCORRECT_PREFIX;
        }

        return ValidationStatus.ACCEPTED;
    }

    @Override
    public PhoneNumber validateAndCorrect(String id, String phoneNumber) {
        ValidationStatus validationStatus = validate(id, phoneNumber);

        PhoneNumber validatedPhoneNumber = new PhoneNumber(id, phoneNumber, validationStatus);

        if(validationStatus == ValidationStatus.CORRECTED_PREFIX) {
            validatedPhoneNumber.setPhoneNumber(PHONE_NUMBER_PREFIX + phoneNumber);
        }

        return validatedPhoneNumber;
    }

    @Override
    public boolean isValid(ValidationStatus validationStatus) {
        return validationStatus.equals(ValidationStatus.ACCEPTED) || validationStatus.equals(ValidationStatus.CORRECTED_PREFIX);
    }

}
