package com.fia.models.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "campañas")
public class Campaña implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=4, max=15)
	private String nombre_campaña;
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private String meta_ventas;
	
	@NotEmpty
	private String fec_inicio;
	
	@NotEmpty
	private String fec_fin;
	
	@NotEmpty
	private String segmento_geografico;
	
	@NotEmpty
	private String dist;

	@NotNull
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecCre;

	public Long getId() {
		return id;
	}

	public String getNombre_campaña() {
		return nombre_campaña;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getMeta_ventas() {
		return meta_ventas;
	}

	public String getFec_inicio() {
		return fec_inicio;
	}

	public String getFec_fin() {
		return fec_fin;
	}

	public String getSegmento_geografico() {
		return segmento_geografico;
	}

	public Date getFecCre() {
		return fecCre;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre_campaña(String nombre_campaña) {
		this.nombre_campaña = nombre_campaña;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setMeta_ventas(String meta_ventas) {
		this.meta_ventas = meta_ventas;
	}

	public void setFec_inicio(String fec_inicio) {
		this.fec_inicio = fec_inicio;
	}

	public void setFec_fin(String fec_fin) {
		this.fec_fin = fec_fin;
	}

	public void setSegmento_geografico(String segmento_geografico) {
		this.segmento_geografico = segmento_geografico;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	
}
