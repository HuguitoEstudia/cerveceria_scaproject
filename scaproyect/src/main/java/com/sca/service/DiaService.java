package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Dia;
import com.sca.model.Respuesta;

public interface DiaService {
	
    public ResponseEntity<Object> save(Dia dia, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(Dia dia, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);

}
