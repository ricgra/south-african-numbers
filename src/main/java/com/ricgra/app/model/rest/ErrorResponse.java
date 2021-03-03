package com.ricgra.app.model.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {

    private String errorCode;
    private String errorMessage;

}
