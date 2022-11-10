package com.qualitest.booking.exceptions;

public class BrowserException extends RuntimeException{

    public BrowserException() {
        super("Wrong browser input in capabilities file");
    }
}
