package com.ricgra.app.model;

public enum ValidationStatus {

    ACCEPTED(""),
    CORRECTED_PREFIX("Corrected invalid phone number prefix"),
    INCORRECT_EMPTY_ID("Id is empty"),
    INCORRECT_EMPTY_PHONE_NUMBER("Phone number is empty"),
    INCORRECT_PHONE_NUMBER_LENGHT("Phone number lenght not valid"),
    INCORRECT_PREFIX("Phone number prefix not valid"),
    INCORRECT_CONTAINS_CHARS("Phone number contains chars");

    private String reason;

    ValidationStatus(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

}
