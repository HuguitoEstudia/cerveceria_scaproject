package com.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sca.model.SueldoBasico;

@Repository
public interface SueldoBasicoRepository extends JpaRepository<SueldoBasico, Long>{
    
}
