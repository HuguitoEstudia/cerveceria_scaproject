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
@Table(name="sueldoBasico")
public class SueldoBasico {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El sueldo_basico no puede estar en blanco")
	@Column(name="sueldo_basico")
	@NotNull
    private Double sueldo_basico;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_Categoria", nullable = false)
    private Categoria categoria;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_Porcentaje_Mes", nullable = false)
    private PorcentajeMes porcentajeMes;

    public SueldoBasico() {
    }

    public SueldoBasico(long id, Double sueldo_basico) {
        this.id = id;
        this.sueldo_basico = sueldo_basico;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public Double getsueldo_basico() {
        return sueldo_basico;
    }

    public void setsueldo_basico(Double sueldo_basico) {
        this.sueldo_basico = sueldo_basico;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public PorcentajeMes getPorcentajeMes() {
        return porcentajeMes;
    }

    public void setPorcentajeMes(PorcentajeMes porcentajeMes) {
        this.porcentajeMes = porcentajeMes;
    }
}
