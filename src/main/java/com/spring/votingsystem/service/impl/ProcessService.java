package com.spring.votingsystem.service.impl;

import com.spring.votingsystem.repository.ProcesoJPARepository;
import com.spring.votingsystem.repository.model.Proceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
    @Autowired
    private ProcesoJPARepository procesoJPARepository;

    public Proceso createProcess(Proceso proceso) {
        return procesoJPARepository.save(proceso);
    }
}
