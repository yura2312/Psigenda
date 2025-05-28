package com.psigenda.psigenda.mapper;

import com.psigenda.psigenda.domain.dto.request.SessaoRequest;
import com.psigenda.psigenda.domain.dto.response.SessaoResponse;
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


        return SessaoResponse
                .builder()
                .id(sessao.getId())
                .comecoSessao(sessao.getComecoSessao())
                .fimSessao(sessao.getFimSessao())
                .descricao(sessao.getDescricao())
                .paciente(sessao.getPaciente())
                .psicologo(sessao.getPsicologo())
                .build();

    }
}
