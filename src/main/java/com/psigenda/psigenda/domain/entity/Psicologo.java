package com.psigenda.psigenda.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Psicologo extends User {
    @Column(nullable = false, unique = true)
    private Long crp;

    @OneToMany(mappedBy = "psicologo"
            , orphanRemoval = true
            , cascade = CascadeType.ALL)

    private List<Sessao> sessoes = new ArrayList<>();

    @OneToMany(mappedBy = "psicologo"
            , cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
            , fetch = FetchType.LAZY)
    private Set<Paciente> pacientes;
}
