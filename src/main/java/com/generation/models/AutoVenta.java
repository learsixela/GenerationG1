package com.generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

//tabla relacional 
@Entity
@Table(name="AutosVentas")
public class AutoVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	private Float subtotal;
	private Date fecha;
	
	/**ManyToMany =  2 ManyToOne*/
	//ManyToOne Auto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="auto_id")
	private Auto auto;
	
	//ManyToOne CompraVenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="compra_venta_id")
	private CompraVenta compraVenta;

	@Column(updatable= false)
	private Date createdAt;
	private Date updatedAt;
	
	public AutoVenta() {

	}

	public AutoVenta(Integer cantidad, Float subtotal, Date fecha, Auto auto) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.fecha = fecha;
		this.auto = auto;
	}

	public Long getId() {
		return id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public Date getFecha() {
		return fecha;
	}

	public Auto getAuto() {
		return auto;
	}

	public CompraVenta getCompraVenta() {
		return compraVenta;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public void setCompraVenta(CompraVenta compraVenta) {
		this.compraVenta = compraVenta;
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
