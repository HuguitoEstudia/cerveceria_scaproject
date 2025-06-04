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

import com.sca.model.PorcentajeMes;
import com.sca.model.Respuesta;
import com.sca.service.impl.PorcentajeMesServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "PorcentajeMes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class PorcentajeMesController {
    Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	PorcentajeMesServiceImpl porcentajeMesServiceImpl;
	
	@PostMapping(value = "/addPorcentajeMes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega una PorcentajeMes", notes = "Esta operación agrega una Porcentaje Mes a la base de datos")
	public ResponseEntity<Object> addPorcentajeMese(@RequestBody @Validated PorcentajeMes porcentajeMes, BindingResult bindingResult) throws BindException{
		return porcentajeMesServiceImpl.save(porcentajeMes,bindingResult);
	}
	
	@GetMapping(value = "/getAllPorcentajeMess", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar PorcentajeMess", notes = "Esta operación devuelve todos los Porcentaje Mes a la base de datos")
	public Respuesta getAllPorcentajeMess() {
		return porcentajeMesServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdPorcentajeMes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar PorcentajeMes por id", notes = "Esta operación consulta un Porcentaje Mes por su identificador personal")
	public Respuesta getByIdPorcentajeMes(@PathParam("id") @PathVariable Long id) {
		return porcentajeMesServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deletePorcentajeMes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un PorcentajeMes", notes = "Esta operación elimina un Porcentaje Mes de la base de datos")
	public Respuesta deletePorcentajeMes(@PathParam("id") @PathVariable Long id) { 
		return porcentajeMesServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updatePorcentajeMes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un PorcentajeMes", notes = "Esta operación actualiza un Porcentaje Mes a la base de datos")
	public ResponseEntity<Object> updatePorcentajeMes(PorcentajeMes porcentajeMes, BindingResult bindingResult) throws BindException {
		return porcentajeMesServiceImpl.update(porcentajeMes, bindingResult);
	}
}
