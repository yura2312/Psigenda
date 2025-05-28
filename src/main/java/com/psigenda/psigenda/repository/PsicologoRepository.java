package com.psigenda.psigenda.repository;

import com.psigenda.psigenda.domain.entity.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsicologoRepository extends JpaRepository <Psicologo, Long> {
    Optional<Psicologo> findByCrp(Long id);
}
