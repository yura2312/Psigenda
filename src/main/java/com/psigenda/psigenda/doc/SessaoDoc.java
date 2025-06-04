package com.psigenda.psigenda.doc;

import com.psigenda.psigenda.domain.dto.request.SessaoRequest;
import com.psigenda.psigenda.domain.dto.response.SessaoResponse;
import com.psigenda.psigenda.domain.dto.response.SessaoSummary;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SessaoDoc {
    @Operation(summary = "Busca todas as sessões marcadas", description = "Método responsável por procurar todos as sessões marcadas")
    @ApiResponse(responseCode = "200", description = "Sessões encontradas com sucesso", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = SessaoResponse.class)))
    })
    public ResponseEntity<List<SessaoResponse>> findAll();

    @Operation(summary = "Busca sessão por ID", description = "Método responsável por procurar sessão pelo ID")
    @ApiResponse(responseCode = "200", description = "Sessões encontradas com sucesso", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = SessaoResponse.class)))
    })
    @ApiResponse(responseCode = "404", description = "Sessão não existe", content = @Content())
    public ResponseEntity<SessaoSummary> findById(@PathVariable Long id);


    @Operation(summary = "Deleta uma sessão por ID", description = "Método responsável por deletar uma sessão")
    @ApiResponse(responseCode = "204", description = "Sessão deletada com sucesso", content = @Content())
    public void delete(@PathVariable Long id);


    @Operation(summary = "Cadastra uma nova sessão", description = "Método responsável por salvar uma sessão")
    @ApiResponse(responseCode = "201", description = "Sessão salva com sucesso", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = SessaoResponse.class))
    })
    @ApiResponse(responseCode = "409", description = "Horário ocupado", content = @Content())
    @ApiResponse(responseCode = "404", description = "Psicólogo ou paciente não encontrado", content = @Content())
    @ApiResponse(responseCode = "400", description = "Erro de digitação no horário da consulta, (começo < fim)", content = @Content())
    public ResponseEntity<SessaoResponse> save(@RequestBody SessaoRequest sessaoRequest);


    @Operation(summary = "Atualizada parcialmente uma sessão",
            description = "Método responsável por alterar os campos de horário baseado no paciente ou psicólogo")
    @ApiResponse(responseCode = "200", description = "Sessão alterada com sucesso",
            content = @Content(mediaType = "application/json",schema = @Schema(implementation = SessaoSummary.class)))
    @ApiResponse(responseCode = "409", description = "Horário ocupado", content = @Content())
    @ApiResponse(responseCode = "", description = "Erro de digitação no horário da consulta, começo <fim",content = @Content())
    public ResponseEntity<SessaoSummary> patch(@PathVariable Long id, @RequestBody SessaoRequest sessaoRequest);


}
