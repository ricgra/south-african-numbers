package com.ricgra.app.model;

import com.ricgra.app.entity.PhoneNumberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneNumber {

    private String id;
    private String phoneNumber;
    private ValidationStatus status;

    public PhoneNumber(PhoneNumberEntity phoneNumberEntity) {
        this.id = phoneNumberEntity.getId();
        this.phoneNumber = phoneNumberEntity.getPhoneNumber();
        this.status = phoneNumberEntity.getStatus();
    }

}
