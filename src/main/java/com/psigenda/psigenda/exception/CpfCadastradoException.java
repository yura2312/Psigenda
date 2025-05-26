package com.psigenda.psigenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CpfCadastradoException extends RuntimeException {

    public CpfCadastradoException(){super ("Cpf já cadastrado");};

    public CpfCadastradoException(String message) {
        super(message);
    }
}
