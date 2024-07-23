package com.spring.votingsystem.repository;

import com.spring.votingsystem.repository.model.UsuarioProceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioProcesoJPARepository extends JpaRepository<UsuarioProceso, Long> {
    List<UsuarioProceso> findAllByProcesoIdProceso(Long idProcess);
}