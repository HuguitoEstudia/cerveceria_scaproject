package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Respuesta;
import com.sca.model.SueldoBasico;

public interface SueldoBasicoService {

    public ResponseEntity<Object> save(SueldoBasico sueldoBasico, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(SueldoBasico sueldoBasico, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);
}
