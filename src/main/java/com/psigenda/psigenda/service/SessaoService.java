package com.psigenda.psigenda.service;


import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.domain.entity.Psicologo;
import com.psigenda.psigenda.domain.entity.Sessao;
import com.psigenda.psigenda.exception.*;
import com.psigenda.psigenda.repository.SessaoRepository;
import lombok.RequiredArgsConstructor;
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

        Optional<Paciente> paciente = pacienteService.findById(sessao.getPaciente().getId());
        Optional<Psicologo> psicologo = psicologoService.findById(sessao.getPsicologo().getId());

        if (paciente.isEmpty()) {
            throw new PacienteException();
        } else if (psicologo.isEmpty()) {
            throw new PsicologoException();
        }

        sessao.setPaciente(paciente.get());
        sessao.setPsicologo(psicologo.get());

        validateSave(sessao);
        return repository.save(sessao);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Sessao patch(Long id, Sessao updatedSessao) {
        Optional<Sessao> foundSessao = repository.findById(id);
        if (foundSessao.isEmpty()) {
            throw new SessaoException();
        }
        Sessao sessao = foundSessao.get();

//        Optional<Paciente> foundPaciente = pacienteService.findById(updatedSessao.getPaciente().getId());
//        if (foundPaciente.isEmpty()) {
//            throw new PacienteException();
//        }
//        Paciente paciente = foundPaciente.get();
//
//        if (updatedSessao.getPaciente() != null) {
//            sessao.setPaciente(paciente);
//        }
        if (updatedSessao.getComecoSessao() != null) {
            sessao.setComecoSessao(updatedSessao.getComecoSessao());
        }
        if (updatedSessao.getFimSessao() != null) {
            sessao.setFimSessao(updatedSessao.getFimSessao());
        }

        validatePatch(id, sessao);
        return repository.save(sessao);
    }

    private void validateSave(Sessao sessao) {

        sessao.setComecoSessao(sessao.getComecoSessao().truncatedTo(ChronoUnit.MINUTES));
        sessao.setFimSessao(sessao.getFimSessao().truncatedTo(ChronoUnit.MINUTES));

        boolean overlap = repository.existsByPsicologoIdAndComecoSessaoLessThanAndFimSessaoGreaterThan(
                sessao.getPsicologo().getId(), sessao.getFimSessao(), sessao.getComecoSessao());

        boolean overlapPaciente = repository.existsByPacienteIdAndComecoSessaoLessThanAndFimSessaoGreaterThan(
                sessao.getPaciente().getId(), sessao.getFimSessao(), sessao.getComecoSessao());

        if (overlap || overlapPaciente) {
            throw new OverlapException();
        }
        if (!sessao.getComecoSessao().isBefore(sessao.getFimSessao())) {
            throw new HorarioException();
        }
    }

    private void validatePatch(Long id, Sessao sessao) {

        sessao.setComecoSessao(sessao.getComecoSessao().truncatedTo(ChronoUnit.MINUTES));
        sessao.setFimSessao(sessao.getFimSessao().truncatedTo(ChronoUnit.MINUTES));

        boolean overlap = repository.existsByPsicologoIdAndComecoSessaoLessThanAndFimSessaoGreaterThanAndIdNot(
                sessao.getPsicologo().getId(), sessao.getFimSessao(), sessao.getComecoSessao(), sessao.getId());

        boolean overlapPaciente = repository.existsByPacienteIdAndComecoSessaoLessThanAndFimSessaoGreaterThanAndIdNot(
                sessao.getPaciente().getId(), sessao.getFimSessao(), sessao.getComecoSessao(), sessao.getId());

        if (overlap || overlapPaciente) {
            throw new OverlapException();
        }
        if (!sessao.getComecoSessao().isBefore(sessao.getFimSessao())) {
            throw new HorarioException();
        }
    }
}
