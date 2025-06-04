package com.sca.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sca.model.Categoria;
import com.sca.model.Respuesta;
import com.sca.service.impl.CategoriaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Categoria")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class CategoriaController {
    Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;
	
	@PostMapping(value = "/addCategoria", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega una categoria", notes = "Esta operación agrega una categoria a la base de datos")
	public ResponseEntity<Object> addCategoriae(@RequestBody @Validated Categoria categoria, BindingResult bindingResult) throws BindException{
		return categoriaServiceImpl.save(categoria,bindingResult);
	}
	
	@GetMapping(value = "/getAllCategorias", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar categorias", notes = "Esta operación devuelve todos los categorias a la base de datos")
	public Respuesta getAllCategorias() {
		return categoriaServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdCategoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar categoria por id", notes = "Esta operación consulta un categoria por su identificador personal")
	public Respuesta getByIdCategoria(@PathParam("id") @PathVariable Long id) {
		return categoriaServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteCategoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un categoria", notes = "Esta operación elimina un categoria de la base de datos")
	public Respuesta deleteCategoria(@PathParam("id") @PathVariable Long id) {
		return categoriaServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateCategoria", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un categoria", notes = "Esta operación actualiza un categoria a la base de datos")
	public ResponseEntity<Object> updateCategoria(@RequestBody Categoria categoria, BindingResult bindingResult) throws BindException {
		return categoriaServiceImpl.update(categoria, bindingResult);
	}
}
