package com.spring.votingsystem.controller;

import com.spring.votingsystem.dto.VotoDTO;
import com.spring.votingsystem.exceptions.ExistVoteRegistryException;
import com.spring.votingsystem.repository.model.Partido;
import com.spring.votingsystem.repository.model.UsuarioProceso;
import com.spring.votingsystem.service.impl.PartidoServiceImpl;
import com.spring.votingsystem.service.impl.UsuarioProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("votes/user-process")
public class UsuarioProcesoController {
    @Autowired
    private UsuarioProcesoService usuarioProcesoService;

    @Autowired
    private PartidoServiceImpl partidoService;

    @GetMapping("get-user-process-email/{emailUser}")
    public ResponseEntity<?> findAllByEmailUsuario(@PathVariable String emailUser) {
        try {
            return ResponseEntity.ok(usuarioProcesoService.findAllByEmailUsuario(emailUser));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("get-user-process-idprocess/{idProcess}")
    public ResponseEntity<List<UsuarioProceso>> findAllByProcesoIdProceso(@PathVariable Long idProcess) {
        try{
            return ResponseEntity.ok(usuarioProcesoService.findAllByProcesoIdProceso(idProcess));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("voting")
    public ResponseEntity<?> voto(@RequestBody VotoDTO votoDTO) {
        try {
            partidoService.vote(votoDTO.idPartido());
            return ResponseEntity.ok(usuarioProcesoService.voto(votoDTO));
        } catch (ExistVoteRegistryException ev) {
            return ResponseEntity.badRequest().body(ev.getMessage());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
