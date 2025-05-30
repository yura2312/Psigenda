package com.psigenda.psigenda.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OverlapException extends RuntimeException {
    public OverlapException(String message) {
        super(message);
    }
}
