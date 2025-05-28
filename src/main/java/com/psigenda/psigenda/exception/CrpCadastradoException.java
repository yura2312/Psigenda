package com.psigenda.psigenda.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CrpCadastradoException extends RuntimeException {

    public CrpCadastradoException() {
        super("Crp já cadastrado");
    }

    public CrpCadastradoException(String message) {
        super(message);
    }
}
