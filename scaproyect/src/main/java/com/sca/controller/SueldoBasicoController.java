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

import com.sca.model.Respuesta;
import com.sca.model.SueldoBasico;
import com.sca.service.impl.SueldoBasicoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "SueldoBasico")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class SueldoBasicoController {
    Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	SueldoBasicoServiceImpl sueldoBasicoServiceImpl;
	
	@PostMapping(value = "/addSueldoBasico", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega un SueldoBasico", notes = "Esta operación agrega un SueldoBasico a la base de datos")
	public ResponseEntity<Object> addSueldoBasicoe(@RequestBody @Validated SueldoBasico sueldoBasico, BindingResult bindingResult) throws BindException{
		return sueldoBasicoServiceImpl.save(sueldoBasico,bindingResult);
	}
	
	@GetMapping(value = "/getAllSueldoBasicos", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar SueldoBasicos", notes = "Esta operación devuelve todos los SueldoBasicos a la base de datos")
	public Respuesta getAllSueldoBasicos() {
		return sueldoBasicoServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdSueldoBasico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar SueldoBasico por id", notes = "Esta operación consulta un SueldoBasico por su identificador personal")
	public Respuesta getByIdSueldoBasico(@PathParam("id") @PathVariable Long id) {
		return sueldoBasicoServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteSueldoBasico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un SueldoBasico", notes = "Esta operación elimina un SueldoBasico de la base de datos")
	public Respuesta deleteSueldoBasico(@PathParam("id") @PathVariable Long id) {
		return sueldoBasicoServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateSueldoBasico", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un SueldoBasico", notes = "Esta operación actualiza un SueldoBasico a la base de datos")
	public ResponseEntity<Object> updateSueldoBasico(SueldoBasico sueldoBasico, BindingResult bindingResult) throws BindException {
		return sueldoBasicoServiceImpl.update(sueldoBasico, bindingResult);
	}
}
