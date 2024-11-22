package com.onecrop.onecrop.exception;

public class EntityExistException extends RuntimeException{
    public EntityExistException(String message) {
        super(message);
    }
}
