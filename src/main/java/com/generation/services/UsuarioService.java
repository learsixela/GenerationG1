package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;

/** Logica de negocio, o validaciones del sistema*/

@Service
public class UsuarioService {
	/* llamar al Repository (inyeccion de dependencia)*/
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public void saveUsuario(Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}

	//obteniendo al lista de usuarios
	public List<Usuario> findAll() {
		
		return null;
	}









	



}
