package com.spring.votingsystem.repository;

import com.spring.votingsystem.repository.model.Proceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProcesoJPARepository extends JpaRepository<Proceso,Long>{
    List<Proceso> findAllByEmailAdmin(String emailAdmin);
}
