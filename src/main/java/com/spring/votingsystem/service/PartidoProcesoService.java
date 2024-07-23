package com.spring.votingsystem.service;

import com.spring.votingsystem.controller.request.PartyRequest;
import com.spring.votingsystem.repository.model.Partido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartidoProcesoService {
    List<Partido> getPartiesPerProcess(String idProcess);
    Boolean chargePartiesPerProcess(List<PartyRequest> partyList, String idProcess);
}
