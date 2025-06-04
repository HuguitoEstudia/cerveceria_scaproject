package com.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sca.model.Asociados;

@Repository
public interface AsociadosRepository extends JpaRepository<Asociados, Long> {
	
	
}
