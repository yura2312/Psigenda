package com.psigenda.psigenda.exception;

public class UserRegisteredException extends RuntimeException {
    public UserRegisteredException() {
    }

    public UserRegisteredException(String message) {
        super(message);
    }
}
