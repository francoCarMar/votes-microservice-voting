package com.spring.votingsystem.service;

import com.spring.votingsystem.controller.request.ProcessRequest;
import com.spring.votingsystem.repository.model.Proceso;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProcesoService {
    List<Proceso> getAllProcesos();
    Optional<Proceso> getProceso(Long idProceso);
    Proceso createProceso(ProcessRequest proceso);
    Proceso modifyProceso(ProcessRequest proceso);
    Proceso setStateProcess(Long id, String estado);
}
