package com.psigenda.psigenda.service;


import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.domain.entity.Psicologo;
import com.psigenda.psigenda.domain.entity.Sessao;
import com.psigenda.psigenda.exception.OverlapException;
import com.psigenda.psigenda.exception.PacienteException;
import com.psigenda.psigenda.exception.PsicologoException;
import com.psigenda.psigenda.exception.SessaoException;
import com.psigenda.psigenda.repository.SessaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SessaoService {

    private final SessaoRepository repository;
    private final PacienteService pacienteService;
    private final PsicologoService psicologoService;


    public Optional<Sessao> findById(Long id) {
        return repository.findById(id);
    }


    public List<Sessao> findAll() {
        return repository.findAll();
    }

    public Sessao save(Sessao sessao) {
        sessao.setComecoSessao(sessao.getComecoSessao().truncatedTo(ChronoUnit.MINUTES));
        sessao.setFimSessao(sessao.getFimSessao().truncatedTo(ChronoUnit.MINUTES));

        Optional<Paciente> paciente = pacienteService.findById(sessao.getPaciente().getId());
        Optional<Psicologo> psicologo = psicologoService.findById(sessao.getPsicologo().getId());

        if (paciente.isEmpty()){
            throw new PacienteException();
        } else if (psicologo.isEmpty()) {
            throw new PsicologoException();
        }

        sessao.setPaciente(paciente.get());
        sessao.setPsicologo(psicologo.get());
        //TODO::Check for double-booking
        boolean overlap = repository.existsByPsicologoIdAndComecoSessaoLessThanAndFimSessaoGreaterThan(
                sessao.getPsicologo().getId(), sessao.getFimSessao(), sessao.getComecoSessao());
        if (overlap){
            throw new OverlapException();
        }
        return repository.save(sessao);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    //TODO: Update method
}
