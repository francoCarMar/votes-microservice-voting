package com.spring.votingsystem.controller;

import com.spring.votingsystem.controller.request.PartyRequest;
import com.spring.votingsystem.repository.model.Partido;
import com.spring.votingsystem.repository.model.Proceso;
import com.spring.votingsystem.service.impl.PartidoServiceImpl;
import com.spring.votingsystem.service.impl.ProcesoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/votes/party")
@RestController
public class PartidoController {

    @Autowired
    private PartidoServiceImpl partidoServiceImpl;

    @Autowired
    private ProcesoServiceImpl procesoServiceImpl;

    @PostMapping("createParty")
    public Partido createParty(@RequestBody PartyRequest partido) {
        return partidoServiceImpl.createParty(partido);
    }

    @PutMapping("modifyParty/{id}")
    public Partido modifyParty(@RequestBody PartyRequest partido) {
        return partidoServiceImpl.modifyParty(partido);
    }

    @GetMapping("get-party/{idProcess}")
    public ResponseEntity<List<Partido>> getPartiesByProcess(@PathVariable Long idProcess) {
        try {
            return ResponseEntity.ok(partidoServiceImpl.getPartiesByProcess(idProcess));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("winner/{idProcess}")
    public ResponseEntity<?> winner(@PathVariable Long idProcess) {
        try {
            List<Partido> partidos = partidoServiceImpl.getPartiesByProcess(idProcess);
            Partido winner = partidos.get(0);
            Proceso proceso = procesoServiceImpl.getProceso(idProcess).orElseThrow();
            for (Partido partido : partidos) {
                if (partido.getNumVotos() == null) {
                    partido.setNumVotos(0L);
                }
                if (partido.getNumVotos() > winner.getNumVotos()) {
                    winner = partido;
                }
            }
            // fecha actual
            Date fechaActual = new Date();
            // fecha fin del proceso
            Date fechaFin = proceso.getFechaFin();
            if(fechaActual.after(fechaFin)){
                proceso.setEstadoProceso("FINALIZADO");
                procesoServiceImpl.setStateProcess(idProcess, "FINALIZADO");
            }else{
                return ResponseEntity.badRequest().body(partidos);
            }
            return ResponseEntity.ok(winner);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}