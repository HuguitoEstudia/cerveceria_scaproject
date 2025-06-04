package com.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sca.model.PorcentajeMes;

@Repository
public interface PorcentajeMesRepository extends JpaRepository<PorcentajeMes, Long>{
    
}
