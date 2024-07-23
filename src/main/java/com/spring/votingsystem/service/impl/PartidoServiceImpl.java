package com.spring.votingsystem.service.impl;

import com.spring.votingsystem.controller.request.PartyRequest;
import com.spring.votingsystem.repository.PartidoJPARepository;
import com.spring.votingsystem.repository.model.Partido;
import com.spring.votingsystem.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoJPARepository partidoRepository;

    @Override
    public Partido getParty(Long id) {
        return partidoRepository.getReferenceById(id);
    }

    @Override
    public Partido createParty(PartyRequest partido) {
        return partidoRepository.save(toEntity(partido));
    }

    @Override
    public Partido modifyParty(PartyRequest partido) {
        return partidoRepository.save(toEntity(partido));
    }

    private Partido toEntity(PartyRequest partyRequest) {
        return Partido.builder()
                .idPartido(partyRequest.getIdPartido())
                .nombrePartido(partyRequest.getNombrePartido())
                .nombrePostulante(partyRequest.getNombrePostulante())
                .imagenPartido(partyRequest.getImagenPartido())
                .build();
    }
}