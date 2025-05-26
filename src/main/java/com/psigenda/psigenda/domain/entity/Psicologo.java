package com.psigenda.psigenda.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
    private List<Sessao> sessoes;
}
