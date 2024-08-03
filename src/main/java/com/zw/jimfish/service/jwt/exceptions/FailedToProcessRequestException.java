package com.zw.jimfish.service.jwt.exceptions;

public class FailedToProcessRequestException extends RuntimeException {
    public FailedToProcessRequestException(String message) {
        super(message);
    }
}
