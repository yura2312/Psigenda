package com.psigenda.psigenda.service;


import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.exception.CpfCadastradoException;
import com.psigenda.psigenda.exception.PacienteException;
import com.psigenda.psigenda.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;

    public Paciente save(Paciente paciente) {
        Optional<Paciente> cpfExiste = repository.findByCpf(paciente.getCpf());
        if (cpfExiste.isPresent()) {
            throw new CpfCadastradoException("Cpf já cadastrado");
        } else {
            return repository.save(paciente);
        }
    }

    public Optional<Paciente> findById(Long id) {
        return repository.findById(id);
    }

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
