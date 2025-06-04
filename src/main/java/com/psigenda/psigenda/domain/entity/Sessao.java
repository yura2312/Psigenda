package com.psigenda.psigenda.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sessao {

    //TODO: Deal with race conditions. probabily not doing it

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "comeco_sessao")
    @FutureOrPresent
    private LocalDateTime comecoSessao;
    @Column(nullable = false, name = "fim_sessao")
    @Future
    private LocalDateTime fimSessao;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "psicologo_id", nullable = false)
    @JsonIgnore
    private Psicologo psicologo;
}
