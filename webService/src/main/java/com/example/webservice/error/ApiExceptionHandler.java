package com.example.webservice.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseStatusExceptionHandler {
    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<Error> handleApiExceptions(ApiBaseException ex, WebRequest request){
        Error error = new Error(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, ex.getStatusCode());
    }
}
