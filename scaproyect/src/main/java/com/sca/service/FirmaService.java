package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Firma;
import com.sca.model.Respuesta;

public interface FirmaService {

    public ResponseEntity<Object> save(Firma firma, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(Firma firma, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);
}
