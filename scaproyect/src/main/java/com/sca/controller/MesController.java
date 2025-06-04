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

import com.sca.model.Mes;
import com.sca.model.Respuesta;
import com.sca.service.impl.MesServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@RestController
@Api(tags = "Mes")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class MesController {

	Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	MesServiceImpl mesServiceImpl;
	
	@PostMapping(value = "/addMes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega un mes", notes = "Esta operación agrega un mes a la base de datos")
	public ResponseEntity<Object> addMes( @Validated @RequestBody Mes mes, BindingResult bindingResult) throws BindException{
		return mesServiceImpl.save(mes,bindingResult);
	}
	
	@GetMapping(value = "/getAllMess", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar mess", notes = "Esta operación devuelve todos los mess a la base de datos")
	public Respuesta getAllMess() {
		return mesServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdMes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar mes por id", notes = "Esta operación consulta un mes por su identificador personal")
	public Respuesta getByIdMes(@PathParam("id") @PathVariable Long id) {
		return mesServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteMes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un mes", notes = "Esta operación elimina un mes de la base de datos")
	public Respuesta deleteMes(@PathParam("id") @PathVariable Long id) {
		return mesServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateMes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un mes", notes = "Esta operación actualiza un mes a la base de datos")
	public ResponseEntity<Object> updateMes(@RequestBody Mes mes, BindingResult bindingResult) throws BindException {
		return mesServiceImpl.update(mes, bindingResult);
	}
}
