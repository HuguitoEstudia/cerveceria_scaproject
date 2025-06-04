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

import com.sca.model.Asistencia;
import com.sca.model.Respuesta;
import com.sca.service.impl.AsistenciaServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "Asistencia")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class AsistenciaController {

Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	AsistenciaServiceImpl AsistenciasServiceImpl;
	
	@PostMapping(value = "/addAsistencias", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega un Asistencias", notes = "Esta operación agrega un Asistencias a la base de datos")
	public ResponseEntity<Object> addAsistencias(@RequestBody @Validated Asistencia asistencia, BindingResult bindingResult) throws BindException{
		return AsistenciasServiceImpl.save(asistencia,bindingResult);
	}
	
	@GetMapping(value = "/getAllAsistencias", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar Asistenciass", notes = "Esta operación devuelve todos los Asistenciass a la base de datos")
	public Respuesta getAllAsistenciass() {
		return AsistenciasServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdAsistencias/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar Asistencias por id", notes = "Esta operación consulta un Asistencias por su identificador personal")
	public Respuesta getByIdAsistencias(@PathParam("id") @PathVariable Long id) {
		return AsistenciasServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteAsistencias/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un Asistencias", notes = "Esta operación elimina un Asistencias de la base de datos")
	public Respuesta deleteAsistencias(@PathParam("id") @PathVariable Long id) {
		return AsistenciasServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateAsistencias", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un Asistencias", notes = "Esta operación actualiza un Asistencias a la base de datos")
	public ResponseEntity<Object> updateAsistencias(Asistencia asistencia, BindingResult bindingResult) throws BindException {
		return AsistenciasServiceImpl.update(asistencia, bindingResult);
	}
}
