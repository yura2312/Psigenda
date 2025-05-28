package com.psigenda.psigenda.exception;

import com.psigenda.psigenda.domain.entity.Sessao;

public class HorarioException extends RuntimeException {
    public HorarioException(){super("Horário impossível");}
}
