package com.ricgra.app.controller;

import com.ricgra.app.model.exception.BaseException;
import com.ricgra.app.model.exception.CSVWriteServiceException;
import com.ricgra.app.model.exception.InvalidInputServiceException;
import com.ricgra.app.model.exception.NullInputServiceException;
import com.ricgra.app.model.rest.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springfox.documentation.annotations.ApiIgnore;

@ControllerAdvice
@ApiIgnore
public class ErrorController {

    @ExceptionHandler({ CSVWriteServiceException.class })
    public ResponseEntity<ErrorResponse> handleCSVWriteServiceException(CSVWriteServiceException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().toString(), e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ NullInputServiceException.class, InvalidInputServiceException.class })
    public ResponseEntity<ErrorResponse> handleInputNotValidServiceException(BaseException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().toString(), e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
