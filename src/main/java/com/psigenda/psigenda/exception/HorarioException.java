package com.psigenda.psigenda.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HorarioException extends RuntimeException {
    public HorarioException(String message) {
        super(message);
    }
}
