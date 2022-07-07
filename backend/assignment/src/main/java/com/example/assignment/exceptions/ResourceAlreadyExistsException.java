package com.example.assignment.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException() {
        super();
    }

    public ResourceAlreadyExistsException(String mess) {
        super(mess);
    }

    public ResourceAlreadyExistsException(String mess, Throwable cause) {
        super(mess, cause);
    }
}
