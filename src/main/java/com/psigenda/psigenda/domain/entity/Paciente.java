package com.psigenda.psigenda.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente extends User {

    @Column(name = "plano_de_saude", nullable = false)
    private Boolean planoDeSaude;

    @OneToMany(mappedBy = "paciente"
            , orphanRemoval = true
            , cascade = CascadeType.ALL)
    private List<Sessao> sessoes;

    @Column(nullable = false, unique = true)
    @CPF
    private Long cpf;
}
