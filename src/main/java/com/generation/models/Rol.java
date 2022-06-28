package com.generation.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;

	//ManyToMany (2 oneToMany)
	@ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
	private List<Usuario> listaUsuario;
	
	@Column(updatable= false)
	private Date createdAt;
	private Date updatedAt;
	
	public Rol() {
		super();
	}
	public Rol(String nombre, String descripcion, List<Usuario> listaUsuario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaUsuario = listaUsuario;
	}
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
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
