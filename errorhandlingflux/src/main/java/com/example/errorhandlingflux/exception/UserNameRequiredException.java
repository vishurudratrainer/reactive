package com.example.errorhandlingflux.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNameRequiredException extends ResponseStatusException {

    public UserNameRequiredException(HttpStatus status, String message, Throwable e) {
        super(status, message, e);
    }
}