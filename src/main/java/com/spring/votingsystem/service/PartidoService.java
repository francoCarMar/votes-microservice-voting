package com.spring.votingsystem.service;

import com.spring.votingsystem.controller.request.PartyRequest;
import com.spring.votingsystem.repository.ProcesoJPARepository;
import com.spring.votingsystem.repository.model.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PartidoService {
    Partido getParty(Long id);
    Partido createParty(PartyRequest partido);
    Partido modifyParty(PartyRequest partido);

    @Service
    class ProcesoService {
        @Autowired
        private ProcesoJPARepository procesoJPARepository;


    }
}
