package com.generation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Cliente;
import com.generation.models.Usuario;
import com.generation.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository cRepository;

	
	public List<Cliente> findAll() {
		// obtener y retornar la lista de usuarios
		return cRepository.findAll();
	}
}
