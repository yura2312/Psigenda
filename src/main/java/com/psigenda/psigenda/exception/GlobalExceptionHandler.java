package com.psigenda.psigenda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CpfCadastradoException.class)
    private ProblemDetail CpfCadastradoHandler(CpfCadastradoException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT, ex.getLocalizedMessage());
        problemDetail.setTitle("CPF já cadastrado");
        problemDetail.setDetail("Informe um CPF válido");
        problemDetail.setProperty("Categoria", "API");

        return problemDetail;
    }

    @ExceptionHandler(CrpCadastradoException.class)
    private ProblemDetail CrpCadastradoHandler(CrpCadastradoException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT, ex.getLocalizedMessage());
        problemDetail.setTitle("CRP já cadastrado");
        problemDetail.setDetail("Informe um CRP válido");
        problemDetail.setProperty("Categoria", "API");

        return problemDetail;
    }

    @ExceptionHandler(HorarioException.class)
    private ProblemDetail HorarioOcupadoHandler(HorarioException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT, ex.getLocalizedMessage());
        problemDetail.setTitle("Horário impossível");
        problemDetail.setDetail("Erro de digitação do começo ou fim da sesão");
        problemDetail.setProperty("Categoria", "Cliente");
        return problemDetail;
    }

    @ExceptionHandler(OverlapException.class)
    private ProblemDetail OverlapHandler(OverlapException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
        problemDetail.setTitle("Horário ocupado");
        problemDetail.setDetail("Informe um horário que não está marcado");
        problemDetail.setProperty("Categoria", "API");
        return problemDetail;
    }

    @ExceptionHandler(PacienteException.class)
    private ProblemDetail PacienteHandler(PacienteException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        problemDetail.setTitle("Paciente não existe");
        problemDetail.setDetail("DIgite um paciente que existe");
        return problemDetail;
    }

    @ExceptionHandler(PsicologoException.class)
    private ProblemDetail PsicologoHandler(PsicologoException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        problemDetail.setTitle("Psicologo não existe");
        return problemDetail;
    }

    @ExceptionHandler(SessaoException.class)
    private ProblemDetail SessaoHandler(SessaoException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        problemDetail.setTitle("Sessão não existe");
        return problemDetail;
    }
}