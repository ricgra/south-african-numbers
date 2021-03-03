package com.ricgra.app.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class InvalidInputServiceException extends BaseException {

    private String message;

    public InvalidInputServiceException(String message) {
        super(ErrorCode.INVALID_INPUT);
        this.message = message;
    }

}
