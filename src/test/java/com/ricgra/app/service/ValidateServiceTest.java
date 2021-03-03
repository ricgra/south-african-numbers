package com.ricgra.app.service;

import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.ValidationStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidateServiceTest {

    final String VALID_PHONE_NUMBER_NO_PREFIX = "831234567";
    final String VALID_PHONE_NUMBER = "27831234567";

    @Autowired
    ValidateService validateService;

    @Test
    public void shouldValidateIdAndPhoneNumber() {
        ValidationStatus status = validateService.validate("1", VALID_PHONE_NUMBER);

        Assertions.assertEquals(status, ValidationStatus.ACCEPTED);
    }

    @Test
    public void shouldNotValidateId() {
        ValidationStatus status = validateService.validate("", VALID_PHONE_NUMBER);

        Assertions.assertEquals(status, ValidationStatus.INCORRECT_EMPTY_ID);
    }

    @Test
    public void shouldCorrectPhoneNumberPrefix() {
        ValidationStatus status = validateService.validatePhoneNumber(VALID_PHONE_NUMBER_NO_PREFIX);

        Assertions.assertEquals(status, ValidationStatus.CORRECTED_PREFIX);
    }

    @Test
    public void shouldInvalidatePhoneNumberForEmptyInput() {
        ValidationStatus status = validateService.validatePhoneNumber("");

        Assertions.assertEquals(status, ValidationStatus.INCORRECT_EMPTY_PHONE_NUMBER);
    }

    @Test
    public void shouldInvalidatePhoneNumberForInputWithChars() {
        ValidationStatus status = validateService.validatePhoneNumber("DELETED_831234567");

        Assertions.assertEquals(status, (ValidationStatus.INCORRECT_CONTAINS_CHARS));
    }

    @Test
    public void shouldInvalidatePhoneNumberForWrongLength() {
        ValidationStatus status = validateService.validatePhoneNumber("278312345671");

        Assertions.assertEquals(status, ValidationStatus.INCORRECT_PHONE_NUMBER_LENGHT);
    }

    @Test
    public void shouldInvalidatePhoneNumberForWrongPrefix() {
        ValidationStatus status = validateService.validatePhoneNumber("37831234567");

        Assertions.assertEquals(status, (ValidationStatus.INCORRECT_PREFIX));
    }

    @Test
    public void shouldValidateAndCorrectPhoneNumber() {
        PhoneNumber phoneNumberCorrected = validateService.validateAndCorrect("1", VALID_PHONE_NUMBER_NO_PREFIX);

        Assertions.assertEquals(phoneNumberCorrected.getStatus(), ValidationStatus.CORRECTED_PREFIX);
        Assertions.assertEquals(phoneNumberCorrected.getPhoneNumber(), VALID_PHONE_NUMBER);
    }

    @Test
    public void shouldReturnTrueOnValidation() {
        Assertions.assertTrue(validateService.isValid(ValidationStatus.ACCEPTED));
    }

}
