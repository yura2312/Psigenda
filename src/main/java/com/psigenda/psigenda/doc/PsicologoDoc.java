package com.psigenda.psigenda.doc;

import com.psigenda.psigenda.domain.dto.request.PsicologoRequest;
import com.psigenda.psigenda.domain.dto.response.PsicologoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PsicologoDoc {
    @Operation(summary = "Cadastra um novo psicólogo", description = "Método responsável por salvar um psicólogo")
    @ApiResponse(responseCode = "201", description = "Psicólogo salvo com sucesso", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PsicologoResponse.class))
    })
    @ApiResponse(responseCode = "409", description = "Psicólogo com CRP já cadastrado", content = @Content())
    public ResponseEntity<PsicologoResponse> save(@RequestBody PsicologoRequest psicologoRequest);


    @Operation(summary = "Busca todos os Psicólogos", description = "Método responsável por procurar todos os psicólogos")
    @ApiResponse(responseCode = "200", description = "Psicólogos encontrados", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = PsicologoResponse.class)))
    })
    public ResponseEntity<List<PsicologoResponse>> findAll();

    @Operation(summary = "Busca psicólogo por ID", description = "Método responsável por procurar um psicólogo pelo ID")
    @ApiResponse(responseCode = "200", description = "Psicólogo encontrado", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PsicologoRequest.class))
    })
    @ApiResponse(responseCode = "404", description = "Psicólogo não encontrado")
    public ResponseEntity<PsicologoResponse> findById(@PathVariable Long id);

    @Operation(summary = "Deleta um psicólogo por ID", description = "Método responsável por deletar um psicólogo")
    @ApiResponse(responseCode = "204", description = "Psicólogo deletado com sucesso", content = @Content())
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}


