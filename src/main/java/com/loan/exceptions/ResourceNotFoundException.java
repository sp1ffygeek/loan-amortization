package com.loan.exceptions;

/**
 * Created by pyada01 on 10/7/16.
 */
public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUUID = 1l;
    private String errorMessage;

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public ResourceNotFoundException() {
    }

}
