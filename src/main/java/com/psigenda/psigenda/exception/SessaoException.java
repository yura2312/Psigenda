package com.psigenda.psigenda.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SessaoException extends RuntimeException {
    public SessaoException(String message) {
        super(message);
    }
}
