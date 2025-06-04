package com.sca.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="porcentajeMes")
public class PorcentajeMes {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El porcentaje_aumento no puede estar en blanco")
	@Column(name="porcentaje_aumento")
	@NotNull
    private Double porcentaje_aumento;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_mes", nullable = false)
    private Mes mes;
    
    @NotNull
    @Column(name="year")
    private int ano;

    public PorcentajeMes() {
    }

    public PorcentajeMes(long id,
			@NotBlank(message = "El porcentaje_aumento no puede estar en blanco") @NotNull Double porcentaje_aumento,
			@NotNull Mes mes, @NotNull int ano) {
		super();
		this.id = id;
		this.porcentaje_aumento = porcentaje_aumento;
		this.mes = mes;
		this.ano = ano;
	}



	public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public Double getporcentaje_aumento() {
        return porcentaje_aumento;
    }

    public void setporcentaje_aumento(Double porcentaje_aumento) {
        this.porcentaje_aumento = porcentaje_aumento;
    }

    public Mes getMes() {
        return mes;
    }

    public void setMes(Mes mes) {
        this.mes = mes;
    }

	public Double getPorcentaje_aumento() {
		return porcentaje_aumento;
	}

	public void setPorcentaje_aumento(Double porcentaje_aumento) {
		this.porcentaje_aumento = porcentaje_aumento;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
    
    
}
