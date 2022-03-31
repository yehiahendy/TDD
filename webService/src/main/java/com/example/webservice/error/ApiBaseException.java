package com.example.webservice.error;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException {
    public ApiBaseException(String s) {
        super(s);
    }

    public abstract HttpStatus getStatusCode();
}
