package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Condicion;
import com.sca.model.Respuesta;

public interface CondicionService {

	public ResponseEntity<Object> save(Condicion condicion, BindingResult bindingResult) throws BindException;

	public ResponseEntity<Object> update(Condicion condicion, BindingResult bindingResult) throws BindException;

	public Respuesta delete(Long id);

	public Respuesta findAll();

	public Respuesta finById(Long id);
}
