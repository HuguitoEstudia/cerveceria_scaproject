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

import com.sca.model.Firma;
import com.sca.model.Respuesta;
import com.sca.service.impl.FirmaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Firma")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class FirmaController {
	
Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	FirmaServiceImpl firmaServiceImpl;
	
	@PostMapping(value = "/addFirma", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega un firma", notes = "Esta operación agrega un firma a la base de datos")
	public ResponseEntity<Object> addDia( @Validated @RequestBody Firma firma, BindingResult bindingResult) throws BindException{
		return firmaServiceImpl.save(firma,bindingResult);
	}
	
	@GetMapping(value = "/getAllFirma", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar firma", notes = "Esta operación devuelve todos los firma a la base de datos")
	public Respuesta getAllFirma() {
		return firmaServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdFirma/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar firma por id", notes = "Esta operación consulta un firma por su identificador personal")
	public Respuesta getByIdFirma(@PathParam("id") @PathVariable Long id) {
		return firmaServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteFirma/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un firma", notes = "Esta operación elimina un firma de la base de datos")
	public Respuesta deleteFirma(@PathParam("id") @PathVariable Long id) {
		return firmaServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateFirma", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar una firma", notes = "Esta operación actualiza una firma a la base de datos")
	public ResponseEntity<Object> updateDia(@RequestBody Firma firma, BindingResult bindingResult) throws BindException {
		return firmaServiceImpl.update(firma, bindingResult);
	}

}
