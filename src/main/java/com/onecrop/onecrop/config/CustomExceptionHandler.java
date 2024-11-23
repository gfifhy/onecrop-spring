package com.onecrop.onecrop.config;


import com.onecrop.onecrop.Exception.EntityExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors =  new HashMap<String, String>();
        ex.getBindingResult().getAllErrors()
                .forEach((error) -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityExistException.class)
    public ResponseEntity<?> handleEntityExistException(EntityExistException ex) {
        var errors =  new HashMap<String, String>();
        if(ex.getMessage().contains("Email")){
            errors.put("Email",ex.getMessage());
        }
        if(ex.getMessage().contains("Username")){
            errors.put("Username",ex.getMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
