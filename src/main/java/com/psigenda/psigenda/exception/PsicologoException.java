package com.psigenda.psigenda.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PsicologoException extends RuntimeException {
    public PsicologoException(String message) {
        super(message);
    }
}
