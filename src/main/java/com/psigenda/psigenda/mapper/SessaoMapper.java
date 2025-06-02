package com.psigenda.psigenda.mapper;

import com.psigenda.psigenda.domain.dto.request.SessaoRequest;
import com.psigenda.psigenda.domain.dto.response.PacienteSummary;
import com.psigenda.psigenda.domain.dto.response.PsicologoSummary;
import com.psigenda.psigenda.domain.dto.response.SessaoResponse;
import com.psigenda.psigenda.domain.dto.response.SessaoSummary;
import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.domain.entity.Psicologo;
import com.psigenda.psigenda.domain.entity.Sessao;

public class SessaoMapper {
    public static Sessao toSessao(SessaoRequest sessaoRequest) {

        Paciente paciente = Paciente
                .builder()
                .id(sessaoRequest.paciente())
                .build();

        Psicologo psicologo = Psicologo
                .builder()
                .id(sessaoRequest.psicologo())
                .build();


        return Sessao
                .builder()
                .comecoSessao(sessaoRequest.comecoSessao())
                .fimSessao(sessaoRequest.fimSessao())
                .paciente(paciente)
                .psicologo(psicologo)
                .build();
    }

    public static SessaoResponse toSessaoResponse(Sessao sessao){

        PacienteSummary paciente = PacienteSummary
                .builder()
                .id(sessao.getPaciente().getId())
                .nome(sessao.getPaciente().getNome())
                .sobrenome(sessao.getPaciente().getSobrenome())
                .cpf(sessao.getPaciente().getCpf())
                .email(sessao.getPaciente().getEmail())
                .build();

        PsicologoSummary psicologo = PsicologoSummary
                .builder()
                .id(sessao.getPsicologo().getId())
                .nome(sessao.getPsicologo().getNome())
                .sobrenome(sessao.getPsicologo().getSobrenome())
                .crp(sessao.getPsicologo().getCrp())
                .email(sessao.getPsicologo().getEmail())
                .build();


        return SessaoResponse
                .builder()
                .id(sessao.getId())
                .comecoSessao(sessao.getComecoSessao())
                .fimSessao(sessao.getFimSessao())
                .descricao(sessao.getDescricao())
                .paciente(paciente)
                .psicologo(psicologo)
                .build();
    }

    public static SessaoSummary toSessaoSummary(Sessao sessao) {
        return SessaoSummary
                .builder()
                .comecoSessao(sessao.getComecoSessao())
                .fimSessao(sessao.getFimSessao())
                .descricao(sessao.getDescricao())
                .build();
    }
}
