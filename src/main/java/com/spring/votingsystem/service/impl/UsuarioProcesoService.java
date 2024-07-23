package com.spring.votingsystem.service.impl;

import com.spring.votingsystem.dto.VotoDTO;
import com.spring.votingsystem.repository.UsuarioProcesoJPARepository;
import com.spring.votingsystem.repository.model.UsuarioProceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioProcesoService {
    @Autowired
    private UsuarioProcesoJPARepository usuarioProcesoJPARepository;

    public List<UsuarioProceso> findAllByEmailUsuario(String emailUser) {
        return usuarioProcesoJPARepository.findAllByEmail(emailUser);
    }

    public List<UsuarioProceso> findAllByProcesoIdProceso(Long idProcess) {
        return usuarioProcesoJPARepository.findAllByProcesoIdProceso(idProcess);
    }

    public UsuarioProceso voto(VotoDTO votoDTO){
        List<UsuarioProceso> usuariosProceso = findAllByProcesoIdProceso(votoDTO.idProceso());
        for (UsuarioProceso usuarioProceso : usuariosProceso) {
            if (usuarioProceso.getEmail().equals(votoDTO.email())) {
                usuarioProceso.setVoto(votoDTO.voto());
                return usuarioProcesoJPARepository.save(usuarioProceso);
            }
        }
        return null;
    }

}
