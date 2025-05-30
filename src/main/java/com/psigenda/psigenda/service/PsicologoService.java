package com.psigenda.psigenda.service;

import com.psigenda.psigenda.domain.entity.Psicologo;
import com.psigenda.psigenda.exception.CrpCadastradoException;
import com.psigenda.psigenda.repository.PsicologoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PsicologoService {

    private final PsicologoRepository repository;

    public Psicologo save(Psicologo psicologo) {
        Optional<Psicologo> crpExiste = repository.findByCrp(psicologo.getCrp());
        if (crpExiste.isPresent()) {
            throw new CrpCadastradoException("Crp já cadastrado");
        } else {
            return repository.save(psicologo);
        }
    }

    public Optional<Psicologo> findById(Long id) {
        return repository.findById(id);
    }

    public List<Psicologo> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
