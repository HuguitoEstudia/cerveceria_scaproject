package com.sca.model;

public class Respuesta {
	
	private String status;
	private String codigo;
	private String descripcion;
	private Object data;

	public Respuesta() {
		super();
	}

	public Respuesta(String status, String codigo, String descripcion) {
		super();
		this.status = status;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}


	public Respuesta(String status, String codigo, String descripcion, Object data) {
		super();
		this.status = status;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
