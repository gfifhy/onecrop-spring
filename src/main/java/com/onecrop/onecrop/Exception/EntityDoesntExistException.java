package com.onecrop.onecrop.Exception;

public class EntityDoesntExistException extends RuntimeException{
    public EntityDoesntExistException(String message) {
        super(message);
    }
}
