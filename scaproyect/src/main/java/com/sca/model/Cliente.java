package com.sca.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sca.constantes.ExpresionRegular;
import com.sca.validator.ValidarExpresionesRegulares;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Column(name="nombre")
	@NotNull
	@ValidarExpresionesRegulares(customMessage = "El nombre no es válido", expresionRegular = ExpresionRegular.NOMBREAPELLIDO)
	private String nombre;
	
	@ValidarExpresionesRegulares(customMessage = "El apellido no es válido", expresionRegular = ExpresionRegular.NOMBREAPELLIDO)
	@NotBlank(message = "El apellido no puede estar en blanco")
	@Column(name="apellido")
	private String apellido;
	
	@ValidarExpresionesRegulares(customMessage = "El documento no es válido", expresionRegular = ExpresionRegular.DOCUMENTO)
	@NotBlank(message = "El documento no puede estar en blanco")
	@Column(name="documento")
	private String documento;
	
	@ValidarExpresionesRegulares(customMessage = "El documento no es válido", expresionRegular = ExpresionRegular.FECHA)
	@Column(name="fecha_nacimiento")
	@ApiModelProperty(value = "Fecha de nacimiento en formato dd/mm/aaaa")
	private String fecha_nacimiento;
	
	@Column(name="direccion")
	private String direccion;
	
	@NotBlank(message = "El mail no puede estar en blanco")
	@Column(name="mail")
	@Email(message = "Error en el formato del mail")
	private String mail;
	
	@ValidarExpresionesRegulares(customMessage = "El cuit no es válido", expresionRegular = ExpresionRegular.CUIT)
	@Column(name="cuit")
	private String cuit;
	
	@ValidarExpresionesRegulares(customMessage = "El teléfono no es válido", expresionRegular = ExpresionRegular.TELEFONO)
	@Column(name="telefono")
	private String telefono;
	
	public Cliente() {
		super();
	}

	public Cliente(long id, String nombre, String apellido, String documento, String fecha_nacimiento, String direccion,
			@Email String mail, String cuit, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.mail = mail;
		this.cuit = cuit;
		this.telefono = telefono;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", mail=" + mail + ", cuit="
				+ cuit + ", telefono=" + telefono + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, direccion, documento, fecha_nacimiento, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(documento, other.documento)
				&& Objects.equals(fecha_nacimiento, other.fecha_nacimiento) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}
	
	
	
}
