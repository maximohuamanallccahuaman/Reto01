package com.reto.Reto01.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="HOSPITAL")
public class Hospital {
	
	@Id
	@Column(name = "IDHOSPITAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="IDDISTRITO")
	private Distrito distrito;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ANTIGUEDAD")
	private String antiguedad;
	
	@Column(name = "AREA")
	private Double area;
	
	@OneToOne
	@JoinColumn(name="IDSEDE")
	private Sede sede;
	
	@OneToOne
	@JoinColumn(name="IDGERENTE")
	private Gerente gerente;
	
	@OneToOne
	@JoinColumn(name="IDCONDICION")
	private Condicion condicion;
	
	@Column(name = "FECHAREGISTRO")
	private Date fecha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", distrito=" + distrito + ", nombre=" + nombre + ", antiguedad=" + antiguedad
				+ ", area=" + area + ", sede=" + sede + ", gerente=" + gerente + ", condicion=" + condicion + ", fecha="
				+ fecha + "]";
	}

	
	
}
