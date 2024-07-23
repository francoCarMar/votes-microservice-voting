package com.spring.votingsystem.service.impl;

import com.spring.votingsystem.controller.request.ProcessRequest;
import com.spring.votingsystem.repository.ProcesoJPARepository;
import com.spring.votingsystem.repository.model.Proceso;
import com.spring.votingsystem.service.ProcesoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcesoServiceImpl implements ProcesoService {

    @Autowired
    private ProcesoJPARepository procesoRepository;

    @Override
    public List<Proceso> getAllProcesos() {
        return procesoRepository.findAll();
    }

    @Override
    public Optional<Proceso> getProceso(Long idProceso) {
        return procesoRepository.findById(idProceso);
    }

    @Override
    public Proceso createProceso(ProcessRequest proceso) {
        return procesoRepository.save(toEntity(proceso));
    }

    @Override
    public Proceso modifyProceso(ProcessRequest proceso) {
        return procesoRepository.save(toEntity(proceso));
    }

    @Override
    public Proceso setStateProcess(Long id, String estado) {
        Optional<Proceso> optionalProceso = procesoRepository.findById(id);

        if (optionalProceso.isPresent()) {
            Proceso proceso = optionalProceso.get();
            proceso.setEstadoProceso(estado);
            return procesoRepository.save(proceso);
        } else {
            throw new RuntimeException("Proceso con ID " + id + " no encontrado");
        }
    }

    public static Proceso toEntity(ProcessRequest processRequest) {
        return Proceso.builder()
                .idProceso(processRequest.getIdProceso())
                .nombreProceso(processRequest.getNombreProceso())
                .fechaInicio(processRequest.getFechaInicio())
                .fechaFin(processRequest.getFechaFin())
                .tiempoEspera(processRequest.getTiempoEspera())
                .partidoProceso(processRequest.getPartidos())
                .estadoProceso(processRequest.getEstadoProceso())
                .build();
    }
}