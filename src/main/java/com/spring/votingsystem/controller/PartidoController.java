package com.spring.votingsystem.controller;

import com.spring.votingsystem.controller.request.PartyRequest;
import com.spring.votingsystem.repository.model.Partido;
import com.spring.votingsystem.service.PartidoProcesoService;
import com.spring.votingsystem.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping("createParty")
    public Partido createParty(@RequestBody PartyRequest partido) {
        return partidoService.createParty(partido);
    }

    @PutMapping("modifyParty/{id}")
    public Partido modifyParty(@RequestBody PartyRequest partido) {
        return partidoService.modifyParty(partido);
    }

}