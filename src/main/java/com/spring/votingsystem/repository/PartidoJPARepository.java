package com.spring.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.votingsystem.repository.model.Partido;

@Repository
public interface PartidoJPARepository extends JpaRepository<Partido,Long>{

}
