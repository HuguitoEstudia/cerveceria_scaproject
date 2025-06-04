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

import com.sca.model.Condicion;
import com.sca.model.Respuesta;
import com.sca.service.impl.CondicionServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Condicion")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class CondicionController {
    Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	CondicionServiceImpl condicionServiceImpl;
	
	@PostMapping(value = "/addCondicion", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega un condicion", notes = "Esta operación agrega un condicion a la base de datos")
	public ResponseEntity<Object> addCondicione(@RequestBody @Validated Condicion condicion, BindingResult bindingResult) throws BindException{
		return condicionServiceImpl.save(condicion,bindingResult);
	}
	
	@GetMapping(value = "/getAllCondicion", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar condicion", notes = "Esta operación devuelve todos los condicion a la base de datos")
	public Respuesta getAllCondicion() {
		return condicionServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdCondicion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar Condicion por id", notes = "Esta operación consulta un condicion por su identificador personal")
	public Respuesta getByIdCondicion(@PathParam("id") @PathVariable Long id) {
		return condicionServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteCondicion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un condicion", notes = "Esta operación elimina un Condicion de la base de datos")
	public Respuesta deleteCondicion(@PathParam("id") @PathVariable Long id) {
		return condicionServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateCondicion", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un condicion", notes = "Esta operación actualiza un condicion a la base de datos")
	public ResponseEntity<Object> updateCondicion(Condicion condicion, BindingResult bindingResult) throws BindException {
		return condicionServiceImpl.update(condicion, bindingResult);
	}
}
