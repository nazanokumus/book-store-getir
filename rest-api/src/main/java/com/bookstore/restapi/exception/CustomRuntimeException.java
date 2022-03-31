package com.bookstore.restapi.exception;

import com.bookstore.restapi.enums.ErrorCodeEnum;
import lombok.Getter;

@Getter
public class CustomRuntimeException extends RuntimeException{
    private ErrorCodeEnum errorCode;

    public CustomRuntimeException(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }
}
