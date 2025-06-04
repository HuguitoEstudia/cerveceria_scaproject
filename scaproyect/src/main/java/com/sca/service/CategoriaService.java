package com.sca.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import com.sca.model.Categoria;
import com.sca.model.Respuesta;

public interface CategoriaService {

    public ResponseEntity<Object> save(Categoria categoria, BindingResult bindingResult) throws BindException;
	
	public ResponseEntity<Object> update(Categoria categoria, BindingResult bindingResult) throws BindException;
	
	public Respuesta delete(Long id);
	
	public Respuesta findAll();
	
	public Respuesta finById(Long id);
}
