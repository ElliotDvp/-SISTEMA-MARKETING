package com.fia.models.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_producto;
	
	@NotEmpty
	@Size(min=2, max=60)
	private String nombre;
	@NotEmpty
	private String marca;
	@NotEmpty
	private String modelo;
	@NotEmpty
	private String tipo;
	@NotEmpty
	private String precio_venta;
	@NotEmpty
	private String precio_viejo;
	@NotEmpty
	private String cantidad_stock;



	
	@ManyToOne
	@JoinColumn(name="campaña_id")
	private Campaña campaña;
	
	public Long getId_producto() {
		return id_producto;
	}

	public String getPrecio_venta() {
		return precio_venta;
	}

	public String getCantidad_stock() {
		return cantidad_stock;
	}

	public Campaña getCampaña() {
		return campaña;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public void setPrecio_venta(String precio_venta) {
		this.precio_venta = precio_venta;
	}

	public void setCantidad_stock(String cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}

	public void setCampaña(Campaña campaña) {
		this.campaña = campaña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPrecio_viejo() {
		return precio_viejo;
	}

	public void setPrecio_viejo(String precio_viejo) {
		this.precio_viejo = precio_viejo;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	

}
