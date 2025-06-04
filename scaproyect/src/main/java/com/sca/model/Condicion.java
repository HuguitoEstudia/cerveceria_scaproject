package com.sca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "condicion")
public class Condicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "La sigla no puede estar en blanco")
    @Column(name = "sigla")
    @NotNull
    private String sigla;

    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion")
    @NotNull
    private String descripcion;

    public Condicion() {
    }

    public Condicion(long id, String sigla, String descripcion) {
        this.id = id;
        this.sigla = sigla;
        this.descripcion = descripcion;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Condicion [id=" + id + ", sigla=" + sigla + ", descripcion=" + descripcion + "]";
	}

  

    
}

