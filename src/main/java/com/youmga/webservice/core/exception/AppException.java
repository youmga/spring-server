package com.youmga.webservice.core.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppException extends RuntimeException {

    @Builder
    public AppException(String message) {
        super(message);
    }

    @Builder
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
