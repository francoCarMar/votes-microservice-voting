package com.spring.votingsystem.controller;

import com.spring.votingsystem.controller.request.PartyRequest;
import com.spring.votingsystem.repository.model.Partido;
import com.spring.votingsystem.service.PartidoProcesoService;
import com.spring.votingsystem.service.PartidoService;
import com.spring.votingsystem.service.impl.PartidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/votes/party")
@RestController
public class PartidoController {

    @Autowired
    private PartidoServiceImpl partidoService;

    @PostMapping("createParty")
    public Partido createParty(@RequestBody PartyRequest partido) {
        return partidoService.createParty(partido);
    }

    @PutMapping("modifyParty/{id}")
    public Partido modifyParty(@RequestBody PartyRequest partido) {
        return partidoService.modifyParty(partido);
    }

    @GetMapping("get-party/{idProcess}")
    public ResponseEntity<List<Partido>> getPartiesByProcess(@PathVariable Long idProcess){
        try{
            return ResponseEntity.ok(partidoService.getPartiesByProcess(idProcess));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}