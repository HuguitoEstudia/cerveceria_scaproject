package com.sca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="asistencia")
public class Asistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	

	@OneToOne
	@JoinColumn(name = "id_condicion", nullable = false)
    private Condicion id_condicion;
	
	@OneToOne
	@JoinColumn(name = "id_asociado", nullable = false)
	private Asociados id_asociado;
	
	@OneToOne
	@JoinColumn(name = "id_dia", nullable = false)
	private Dia id_dia;
	
	@Column(name="horaEntrada")
    private String horaEntrada;
	
	@Column(name="horaSalida")
    private String horaSalida;
	
	@Column(name="fecha")
    private LocalDate fecha;
	
	@Column(name="observacion")
    private String observacion;
	
	@Column(name="subTotal")
    private String subtotal;

    public Asistencia() {
    }

	public Asistencia(long id, Condicion id_condicion, Asociados id_asociado, Dia id_dia, String horaEntrada,
			String horaSalida, LocalDate fecha, String observacion, String subtotal) {
		super();
		this.id = id;
		this.id_condicion = id_condicion;
		this.id_asociado = id_asociado;
		this.id_dia = id_dia;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.fecha = fecha;
		this.observacion = observacion;
		this.subtotal = subtotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Condicion getId_condicion() {
		return id_condicion;
	}

	public void setId_condicion(Condicion id_condicion) {
		this.id_condicion = id_condicion;
	}

	public Asociados getId_asociado() {
		return id_asociado;
	}

	public void setId_asociado(Asociados id_asociado) {
		this.id_asociado = id_asociado;
	}

	public Dia getId_dia() {
		return id_dia;
	}

	public void setId_dia(Dia id_dia) {
		this.id_dia = id_dia;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

   
}
