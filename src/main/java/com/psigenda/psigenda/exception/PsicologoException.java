package com.psigenda.psigenda.exception;

public class PsicologoException extends RuntimeException {
    public PsicologoException() {
        super("Psicologo não existe");
    }
}
