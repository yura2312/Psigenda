package com.psigenda.psigenda.doc;

import com.psigenda.psigenda.domain.dto.request.PacienteRequest;
import com.psigenda.psigenda.domain.dto.response.PacienteResponse;
import com.psigenda.psigenda.exception.PacienteException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PacienteDoc {

    @Operation(summary = "Cadastra um novo paciente", description = "Método responsável por salvar um paciente")
    @ApiResponse(responseCode = "201", description = "Paciente salvo com sucesso", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PacienteResponse.class))
    })
    @ApiResponse(responseCode = "409", description = "Paciente com CPF já cadastrado", content = @Content())
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest pacienteRequest);


    @Operation(summary = "Busca todos os paciente", description = "Método responsável por procurar todos os paciente")
    @ApiResponse(responseCode = "200", description = "Pacientes encontrados", content = {
            @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = PacienteResponse.class)))
    })
    public ResponseEntity<List<PacienteResponse>> findAll();

    @Operation(summary = "Busca paciente por ID", description = "Método responsável por procurar um paciente pelo ID")
    @ApiResponse(responseCode = "200", description = "Paciente encontrado", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PacienteResponse.class))
    })
    @ApiResponse(responseCode = "404", description = "Paciente não encontrado", content = @Content())
    public ResponseEntity<PacienteResponse> findById(@PathVariable Long id);

    @Operation(summary = "Deleta um paciente por ID", description = "Método responsável por deletar um paciente")
    @ApiResponse(responseCode = "204", description = "Paciente deletado com sucesso", content = @Content())
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}
