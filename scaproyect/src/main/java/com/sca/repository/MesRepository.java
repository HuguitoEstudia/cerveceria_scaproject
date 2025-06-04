package com.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sca.model.Mes;

@Repository
public interface MesRepository extends JpaRepository <Mes, Long> {

}
