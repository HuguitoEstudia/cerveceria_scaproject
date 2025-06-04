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

import com.sca.model.AsistenciaTotal;
import com.sca.model.Respuesta;
import com.sca.service.impl.AsistenciaTotalServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "AsistenciaTotalTotal")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@Slf4j
public class AsistenciaTotalController {

Logger log = LoggerFactory.getLogger(String.class);
	
	@Autowired
	AsistenciaTotalServiceImp asistenciaTotalServiceImpl;
	
	@PostMapping(value = "/addAsistenciaTotalTotal", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Agrega una asistencia total", notes = "Esta operación agrega una asistencia total total a la base de datos")
	public ResponseEntity<Object> addAsistenciaTotal(@RequestBody @Validated AsistenciaTotal asistenciaTotal, BindingResult bindingResult) throws BindException{
		return asistenciaTotalServiceImpl.save(asistenciaTotal,bindingResult);
	}
	
	@GetMapping(value = "/getAllAsistenciaTotales", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar Asistencia totales", notes = "Esta operación devuelve todos los Asistencia totales a la base de datos")
	public Respuesta getAllAsistenciaTotals() {
		return asistenciaTotalServiceImpl.findAll();
	}
	
	@GetMapping(value = "/getByIdAsistenciaTotal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consultar asistencia totales por id", notes = "Esta operación consulta un asistencia total por su identificador personal")
	public Respuesta getByIdAsistenciaTotal(@PathParam("id") @PathVariable Long id) {
		return asistenciaTotalServiceImpl.finById(id);
	}
	
	@DeleteMapping(value = "/deleteAsistenciaTotal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Eliminar un asistencia total", notes = "Esta operación elimina un asistencia total de la base de datos")
	public Respuesta deleteAsistenciaTotal(@PathParam("id") @PathVariable Long id) {
		return asistenciaTotalServiceImpl.delete(id);
	}
	
	@PutMapping(value = "/updateAsistenciaTotal", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar un asistencia total", notes = "Esta operación actualiza una asistencia total a la base de datos")
	public ResponseEntity<Object> updateAsistenciaTotal(AsistenciaTotal asistencia, BindingResult bindingResult) throws BindException {
		return asistenciaTotalServiceImpl.update(asistencia, bindingResult);
	}
}
