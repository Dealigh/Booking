package com.qualitest.booking.exceptions;

public class PropertiesException extends RuntimeException{
    public PropertiesException() {
        super("Error connecting to Properties File");
    }
}
