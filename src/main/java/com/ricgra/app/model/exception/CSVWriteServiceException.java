package com.ricgra.app.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CSVWriteServiceException extends BaseException {

    private String message;

    public CSVWriteServiceException(String message) {
        super(ErrorCode.CSV_WRITE_ERROR);
        this.message = message;
    }

}
