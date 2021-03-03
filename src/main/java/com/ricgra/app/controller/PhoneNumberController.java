package com.ricgra.app.controller;

import com.ricgra.app.model.PhoneNumber;
import com.ricgra.app.model.rest.PhoneNumberOutput;
import com.ricgra.app.model.ValidationStatus;
import com.ricgra.app.model.rest.ValidationOutput;
import com.ricgra.app.service.DownloadService;
import com.ricgra.app.service.ValidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/phone-number")
@Api("CSV file controller")
public class PhoneNumberController {

    @Autowired
    DownloadService downloadService;

    @Autowired
    ValidateService validateService;

    @GetMapping
    @ApiOperation("Download all records as JSON")
    public ResponseEntity<PhoneNumberOutput> download() {
        List<PhoneNumber> phoneNumberList = downloadService.download();

        PhoneNumberOutput output = new PhoneNumberOutput(phoneNumberList, phoneNumberList.size());

        return ResponseEntity.ok(output);
    }

    @GetMapping(path = "/{phoneNumber}/validate")
    @ApiOperation("Validate a single phone number")
    public ResponseEntity<ValidationOutput> validate(@PathVariable("phoneNumber") String phoneNumber) {
        ValidationStatus status = validateService.validatePhoneNumber(phoneNumber);

        boolean isValid = validateService.isValid(status);
        String message = status.getReason();

        return ResponseEntity.ok(new ValidationOutput(isValid, message));
    }

}
