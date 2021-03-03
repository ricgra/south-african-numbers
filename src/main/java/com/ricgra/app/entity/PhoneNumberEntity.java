package com.ricgra.app.entity;

import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.ValidationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone_numbers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneNumberEntity {

    @Id
    @Column(unique = true, updatable = false, nullable = false)
    private String id;
    @Column(unique = true, nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private ValidationStatus status;
    @Column(nullable = false)
    private String reason;

    public PhoneNumberEntity(PhoneNumber phoneNumber) {
        this.id = phoneNumber.getId();
        this.phoneNumber = phoneNumber.getPhoneNumber();
        if(phoneNumber.getStatus() != null) {
            this.status = phoneNumber.getStatus();
            this.reason = phoneNumber.getStatus().getReason();
        }
    }

}
