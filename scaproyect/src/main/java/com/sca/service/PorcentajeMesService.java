package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.PorcentajeMes;
import com.sca.model.Respuesta;

public interface PorcentajeMesService {

    public ResponseEntity<Object> save(PorcentajeMes porcentajeMes, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(PorcentajeMes porcentajeMes, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);
}
