package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Asistencia;
import com.sca.model.AsistenciaTotal;
import com.sca.model.Asociados;
import com.sca.model.Respuesta;

public interface AsistenciaTotalService {

	public ResponseEntity<Object> save(AsistenciaTotal asistencia, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(AsistenciaTotal asistencia, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);
}
