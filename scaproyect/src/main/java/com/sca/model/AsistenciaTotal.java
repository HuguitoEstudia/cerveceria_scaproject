package com.sca.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="asistenciaTotal")
public class AsistenciaTotal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@OneToOne
	@JoinColumn(name = "id_mes", nullable = false)
	private Mes id_mes;
    
	@Column(name="year")
	private int ano;
	
	@ManyToOne
	@JoinColumn(name = "id_asistencia", nullable = false)
	private Asociados id_asistencia;
	
	@Column(name="tiempoHoraAnual")
    private String tiempo_hora_anual;
	
	@Column(name="tiempoHoraMensual")
    private String tiempo_hora_mensual;
	
	@Column(name="TiempoHoraPrimeraQuincena")
    private String tiempo_hora_primera_quincena;
	
	@Column(name="TiempoSegundaQuincena")
    private String tiempo_hora_segunda_quincena;

    public AsistenciaTotal() {
    }

	public AsistenciaTotal(long id, Mes id_mes, int ano, Asociados id_asistencia, String tiempo_hora_anual,
			String tiempo_hora_mensual, String tiempo_hora_primera_quincena, String tiempo_hora_segunda_quincena) {
		super();
		this.id = id;
		this.id_mes = id_mes;
		this.ano = ano;
		this.id_asistencia = id_asistencia;
		this.tiempo_hora_anual = tiempo_hora_anual;
		this.tiempo_hora_mensual = tiempo_hora_mensual;
		this.tiempo_hora_primera_quincena = tiempo_hora_primera_quincena;
		this.tiempo_hora_segunda_quincena = tiempo_hora_segunda_quincena;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mes getId_mes() {
		return id_mes;
	}

	public void setId_mes(Mes id_mes) {
		this.id_mes = id_mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Asociados getId_asistencia() {
		return id_asistencia;
	}

	public void setId_asistencia(Asociados id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	public String getTiempo_hora_anual() {
		return tiempo_hora_anual;
	}

	public void setTiempo_hora_anual(String tiempo_hora_anual) {
		this.tiempo_hora_anual = tiempo_hora_anual;
	}

	public String getTiempo_hora_mensual() {
		return tiempo_hora_mensual;
	}

	public void setTiempo_hora_mensual(String tiempo_hora_mensual) {
		this.tiempo_hora_mensual = tiempo_hora_mensual;
	}

	public String getTiempo_hora_primera_quincena() {
		return tiempo_hora_primera_quincena;
	}

	public void setTiempo_hora_primera_quincena(String tiempo_hora_primera_quincena) {
		this.tiempo_hora_primera_quincena = tiempo_hora_primera_quincena;
	}

	public String getTiempo_hora_segunda_quincena() {
		return tiempo_hora_segunda_quincena;
	}

	public void setTiempo_hora_segunda_quincena(String tiempo_hora_segunda_quincena) {
		this.tiempo_hora_segunda_quincena = tiempo_hora_segunda_quincena;
	}

   
}
