package com.psigenda.psigenda.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "comeco_sessao")
    private LocalDateTime comecoSessao;
    @Column(nullable = false, name = "fim_sessao")
    private LocalDateTime fimSessao;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "psicologo_id", nullable = false)
    private Psicologo psicologo;
}
