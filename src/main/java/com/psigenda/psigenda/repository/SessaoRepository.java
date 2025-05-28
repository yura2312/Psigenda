package com.psigenda.psigenda.repository;

import com.psigenda.psigenda.domain.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    Optional<Sessao> findByComecoSessao(LocalDateTime comecoSessao);

    boolean existsByPsicologoIdAndComecoSessaoLessThanAndFimSessaoGreaterThan(
            Long psicologoId, LocalDateTime fim, LocalDateTime comeco);

}
