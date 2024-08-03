package com.zw.jimfish.service.jwt.exceptions;

@SuppressWarnings("serial")
public class EmailException extends RuntimeException {
    public EmailException(String message) {
        super(message);
    }
    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }

}
