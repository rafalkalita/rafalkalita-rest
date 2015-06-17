package com.rafalkalita.domain;

/**
 * Class for representing an error.
 */
public class Error {

    private final String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
