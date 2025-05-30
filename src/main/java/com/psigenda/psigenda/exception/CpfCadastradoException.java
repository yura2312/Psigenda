package com.psigenda.psigenda.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
public class CpfCadastradoException extends RuntimeException {

    public CpfCadastradoException(String message) {
        super(message);
    }

}
