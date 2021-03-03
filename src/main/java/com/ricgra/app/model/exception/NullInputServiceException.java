package com.ricgra.app.model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NullInputServiceException extends BaseException {

    private String message;

    public NullInputServiceException(String message) {
        super(ErrorCode.NULL_INPUT);
        this.message = message;
    }

}
