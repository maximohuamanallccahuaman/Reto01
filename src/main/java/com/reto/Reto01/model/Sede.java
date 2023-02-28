package com.reto.Reto01.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SEDE")
public class Sede {
	
	@Id
	@Column(name = "IDSEDE")
	private Integer id;
	@Column(name = "DESCSEDE")
	private String descripcion;
	@Column(name = "FECHAREGISTRO")
	private Date fecha;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "Sede [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + "]";
	}

	
}
