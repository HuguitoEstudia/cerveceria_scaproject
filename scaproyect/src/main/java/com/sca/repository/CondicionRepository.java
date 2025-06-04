package com.sca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sca.model.Condicion;

@Repository
public interface CondicionRepository extends JpaRepository<Condicion, Long> {

}
