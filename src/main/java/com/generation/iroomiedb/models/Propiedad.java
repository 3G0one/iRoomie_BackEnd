package com.generation.iroomiedb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="propiedad")
public class Propiedad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id; 
	private String nombre;
	private double precio;
	private String foto;
	private String direccion;
	private String municipio;
	private String banios;
	private String habitaciones;
	//faltan las llaves foraneas nene
	
	
	public Propiedad(Long id, String nombre, double precio, String foto, String direccion, String municipio,
			String banios, String habitaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.foto = foto;
		this.direccion = direccion;
		this.municipio = municipio;
		this.banios = banios;
		this.habitaciones = habitaciones;
		
	}//constructorPropiedad
	
	public Propiedad() {
		super();
	}//constructor vacio

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBanios() {
		return banios;
	}

	public void setBanios(String banios) {
		this.banios = banios;
	}

	public String getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(String habitaciones) {
		this.habitaciones = habitaciones;
	}

	@Override
	public String toString() {
		return "Propiedad [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", foto=" + foto + ", direccion="
				+ direccion + ", municipio=" + municipio + ", banios=" + banios + ", habitaciones=" + habitaciones
				+ "]";
	}//toString


}
