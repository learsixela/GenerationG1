package com.generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max= 20)
	private String nombre;
	
	@Size(min=3, max= 20)
	private String apellido;
	
	private Integer edad;
	
	@NotNull
	@Size(min=6, max= 8)
	private String password;
	
	@Column(updatable= false)
	private Date createdAt;
	
	private Date updatedAt;
	
	//constructores
	public Usuario() {
		super();
	}
	public Usuario(String nombre, String apellido, Integer edad,String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.password= password;
	}
	//Getters& Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
