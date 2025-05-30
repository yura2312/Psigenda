package com.psigenda.psigenda.exception;


import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
public class CrpCadastradoException extends RuntimeException {

    public CrpCadastradoException(String message) {
        super(message);
    }

}
