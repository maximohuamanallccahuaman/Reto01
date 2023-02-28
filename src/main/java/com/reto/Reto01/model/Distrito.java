package com.reto.Reto01.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DISTRITO")
public class Distrito {
	
	@Id
	@Column(name = "IDDISTRITO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="IDPROVINCIA")
	private Provincia provincia;
	
	@Column(name = "DESCDISTRITO")
	private String descripcion;
	
	@Column(name = "FECHAREGISTRO")
	private Date fecha;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Distrito [id=" + id + ", provincia=" + provincia + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ "]";
	}
}
