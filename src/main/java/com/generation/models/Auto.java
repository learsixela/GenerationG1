package com.generation.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="autos")
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Float velocidad;
	private String color;
	private Float valor;
	
	//ManyToMany AutosVentas
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="autos_ventas",//nombre tabla relacional
			joinColumns = @JoinColumn(name="auto_id"),//desde la entidad actual
			inverseJoinColumns= @JoinColumn(name="compra_venta_id")//la otra entidad o tabla
			)
	private List<CompraVenta> comprasVentas;
	
	
	@Column(updatable= false)
	private Date createdAt;
	private Date updatedAt;
	
	
    public Auto() {
		super();
	}
    
	public Auto(String marca, String modelo, Float velocidad, String color, Float valor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.color = color;
		this.valor = valor;
	}


	public Auto(String marca, String modelo, Float velocidad, String color, Float valor,
			List<CompraVenta> comprasVentas) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.color = color;
		this.valor = valor;
		this.comprasVentas = comprasVentas;
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Float getVelocidad() {
		return velocidad;
	}

	public String getColor() {
		return color;
	}

	public Float getValor() {
		return valor;
	}

	public List<CompraVenta> getComprasVentas() {
		return comprasVentas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setVelocidad(Float velocidad) {
		this.velocidad = velocidad;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public void setComprasVentas(List<CompraVenta> comprasVentas) {
		this.comprasVentas = comprasVentas;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
