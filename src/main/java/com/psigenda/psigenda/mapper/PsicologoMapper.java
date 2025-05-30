package com.psigenda.psigenda.mapper;

import com.psigenda.psigenda.domain.dto.request.PsicologoRequest;
import com.psigenda.psigenda.domain.dto.response.PsicologoResponse;
import com.psigenda.psigenda.domain.entity.Psicologo;
import com.psigenda.psigenda.domain.entity.Sessao;

import java.util.List;

public class PsicologoMapper {

    public static Psicologo toPsicologo(PsicologoRequest psicologoRequest) {

        List<Sessao> sessoes = psicologoRequest.sessoes()
                .stream()
                .map(sessaoId -> Sessao.builder().id(sessaoId).build())
                .toList();

        return Psicologo
                .builder()
                .nome(psicologoRequest.nome())
                .sobrenome(psicologoRequest.sobrenome())
                .email(psicologoRequest.email())
                .crp(psicologoRequest.crp())
                .sessoes(sessoes)
                .build();
    }

    public static PsicologoResponse toPsicologoResponse(Psicologo psicologo) {

        //TODO: Mapper sessao
        List<Sessao> sessoes = psicologo.getSessoes();

        return PsicologoResponse
                .builder()
                .id(psicologo.getId())
                .nome(psicologo.getNome())
                .sobrenome(psicologo.getSobrenome())
                .email(psicologo.getEmail())
                .crp(psicologo.getCrp())
                .sessoes(sessoes)
                .build();
    }
}
