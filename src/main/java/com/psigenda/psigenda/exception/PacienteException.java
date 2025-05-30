package com.psigenda.psigenda.exception;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class PacienteException extends RuntimeException {
    public PacienteException(String message) {
        super(message);
    }

}
