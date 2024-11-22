package com.onecrop.onecrop.exception;

public class EntityDoesntExistException extends RuntimeException{
    public EntityDoesntExistException(String message) {
        super(message);
    }
}
