package com.ricgra.app.model.rest;

import com.ricgra.app.model.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneNumberOutput {

    private List<PhoneNumber> phoneNumbers;
    private int count;

}
