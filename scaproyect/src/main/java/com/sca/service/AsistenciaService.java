package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Asistencia;
import com.sca.model.Asociados;
import com.sca.model.Respuesta;

public interface AsistenciaService {

	public ResponseEntity<Object> save(Asistencia asistencia, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(Asistencia asistencia, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);
}
