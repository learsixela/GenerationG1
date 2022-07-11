package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
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
	
	
	public boolean saveUsuario(Usuario usuario) {
		boolean error=true;
		//validaciones de insercion(crear o registrar usuario)
		//1.- validar si email existe el la bd
		Usuario existeUsuario = usuarioRepository.findByEmail(usuario.getEmail());
		
			//si no existe el usuario, lo creamos
			if(existeUsuario == null) {
				
				//2.- encriptar el password
				//123456 => $awfsghertvnkejlrhgvkluehrgewrgeh
				String passEncriptado = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
				usuario.setPassword(passEncriptado);
				
				usuarioRepository.save(usuario);
				error=false;
			}
			//si existe, retornamos un boolean true
			else {
				error=true;//error en la creacion, ya existe
				
			}
		
		return error;
		
	}

	
	public List<Usuario> findAll() {
		//obtener y retornar la lista de usuarios
		return usuarioRepository.findAll();
	}









	



}
