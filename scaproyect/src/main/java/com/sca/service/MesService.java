package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Mes;
import com.sca.model.Respuesta;

public interface MesService {
	public ResponseEntity<Object> save(Mes mes, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(Mes mes, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);
	
}
