package com.onecrop.onecrop.config;


import com.onecrop.onecrop.exception.EntityExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class CustomExceptionHandler {

    //keeping this response entity return for record only
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
        String entity = ex.getMessage().split(" ")[0];
        errors.put(entity,ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Invalid JSON format: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String, String>> global(Exception ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("message", "There was an error with your request");
        error.put("error",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
