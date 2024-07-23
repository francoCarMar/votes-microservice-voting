package com.spring.votingsystem.service.impl;

import com.spring.votingsystem.controller.request.PartyRequest;
import com.spring.votingsystem.repository.PartidoJPARepository;
import com.spring.votingsystem.repository.model.Partido;
import com.spring.votingsystem.repository.model.Proceso;
import com.spring.votingsystem.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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
        return Partido.builder().idPartido(partyRequest.getIdPartido()).nombrePartido(partyRequest.getNombrePartido()).nombrePostulante(partyRequest.getNombrePostulante()).imagenPartido(partyRequest.getImagenPartido()).build();
    }

    public Partido vote(Long idPartido) {
        Partido partido = partidoRepository.findById(idPartido).orElseThrow();
        if(partido.getNumVotos() == null)
            partido.setNumVotos(0L);
        partido.setNumVotos((partido.getNumVotos() + 1));
        return partidoRepository.save(partido);
    }

    public List<Partido> getPartiesByProcess(Long idProcess) {
        List<Partido> partidos = partidoRepository.findAllByProcesoIdProceso(idProcess);
        if (partidos.isEmpty()) {
            throw new RuntimeException("No se encontraron partidos para el proceso con ID " + idProcess);
        }
        return partidos;
    }


    public Object winner(Proceso proceso){
        List<Partido> partidos = partidoRepository.findAllByProcesoIdProceso(proceso.getIdProceso());
        Partido winner = partidos.get(0);
        for (Partido partido : partidos) {
            if(partido.getNumVotos() > winner.getNumVotos()){
                winner = partido;
            }
        }
        Date fechaActual = new Date();
        Date fechaFin = proceso.getFechaFin();
        if(fechaActual.after(fechaFin)){
            return winner.getNombrePartido();
        }else{
            return partidos;
        }

    }
}