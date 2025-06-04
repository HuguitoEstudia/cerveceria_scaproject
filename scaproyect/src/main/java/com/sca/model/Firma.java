package com.sca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="firma")
public class Firma {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name="firma")
    private String firma;
    
	 @Lob
	 private byte[] dedo1;

	 @Lob
	 private byte[] dedo2;
	 
	 @Lob
	 private byte[] dedo3;

	 @Lob
	 private byte[] dedo4;

	public Firma(long id, String firma, byte[] dedo1, byte[] dedo2, byte[] dedo3, byte[] dedo4) {
		super();
		this.id = id;
		this.firma = firma;
		this.dedo1 = dedo1;
		this.dedo2 = dedo2;
		this.dedo3 = dedo3;
		this.dedo4 = dedo4;
	}

	public Firma() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public byte[] getDedo1() {
		return dedo1;
	}

	public void setDedo1(byte[] dedo1) {
		this.dedo1 = dedo1;
	}

	public byte[] getDedo2() {
		return dedo2;
	}

	public void setDedo2(byte[] dedo2) {
		this.dedo2 = dedo2;
	}

	public byte[] getDedo3() {
		return dedo3;
	}

	public void setDedo3(byte[] dedo3) {
		this.dedo3 = dedo3;
	}

	public byte[] getDedo4() {
		return dedo4;
	}

	public void setDedo4(byte[] dedo4) {
		this.dedo4 = dedo4;
	}
	
	
}
