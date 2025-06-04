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

import com.sca.model.Asociados;
import com.sca.model.Respuesta;
import com.sca.service.impl.AsociadosServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Asociados")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class AsociadosController {
	
	Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	AsociadosServiceImpl AsociadosServiceImpl;
	
	@PostMapping(value = "/addAsociados", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega un Asociados", notes = "Esta operación agrega un Asociados a la base de datos")
	public ResponseEntity<Object> addAsociados(@RequestBody @Validated Asociados asociados, BindingResult bindingResult) throws BindException{
		return AsociadosServiceImpl.save(asociados,bindingResult);
	}
	
	@GetMapping(value = "/getAllAsociadoss", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar Asociadoss", notes = "Esta operación devuelve todos los Asociadoss a la base de datos")
	public Respuesta getAllAsociadoss() {
		return AsociadosServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdAsociados/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar Asociados por id", notes = "Esta operación consulta un Asociados por su identificador personal")
	public Respuesta getByIdAsociados(@PathParam("id") @PathVariable Long id) {
		return AsociadosServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteAsociados/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un Asociados", notes = "Esta operación elimina un Asociados de la base de datos")
	public Respuesta deleteAsociados(@PathParam("id") @PathVariable Long id) {
		return AsociadosServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateAsociados", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un Asociados", notes = "Esta operación actualiza un Asociados a la base de datos")
	public ResponseEntity<Object> updateAsociados(Asociados asociados, BindingResult bindingResult) throws BindException {
		return AsociadosServiceImpl.update(asociados, bindingResult);
	}
}
