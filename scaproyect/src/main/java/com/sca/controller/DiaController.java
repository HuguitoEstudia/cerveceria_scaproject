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

import com.sca.model.Dia;
import com.sca.model.Respuesta;
import com.sca.service.impl.DiaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Dia")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class DiaController {

Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	DiaServiceImpl diaServiceImpl;
	
	@PostMapping(value = "/addDia", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega un dia", notes = "Esta operación agrega un dia a la base de datos")
	public ResponseEntity<Object> addDia( @Validated @RequestBody Dia dia, BindingResult bindingResult) throws BindException{
		return diaServiceImpl.save(dia,bindingResult);
	}
	
	@GetMapping(value = "/getAllDia", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar dia", notes = "Esta operación devuelve todos los dia a la base de datos")
	public Respuesta getAllDia() {
		return diaServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdDia/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar dia por id", notes = "Esta operación consulta un dia por su identificador personal")
	public Respuesta getByIdDia(@PathParam("id") @PathVariable Long id) {
		return diaServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteDia/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un dia", notes = "Esta operación elimina un dia de la base de datos")
	public Respuesta deleteDia(@PathParam("id") @PathVariable Long id) {
		return diaServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateDia", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un dia", notes = "Esta operación actualiza un dia a la base de datos")
	public ResponseEntity<Object> updateDia(@RequestBody Dia dia, BindingResult bindingResult) throws BindException {
		return diaServiceImpl.update(dia, bindingResult);
	}
}
