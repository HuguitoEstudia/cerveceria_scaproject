package com.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sca.model.Asistencia;
import com.sca.model.Dia;

@Repository
public interface AsistenciaRepository extends JpaRepository <Asistencia, Long> {

}
