package com.psigenda.psigenda.exception;

public class OverlapException extends RuntimeException {
   public OverlapException(){super("Horário já está ocupado por outro paciente!");}
}
