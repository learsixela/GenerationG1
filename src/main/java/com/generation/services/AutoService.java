package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;

@Service
public class AutoService {
	@Autowired
	AutoRepository autoRepository;

	//guardar un auto 
	public void guardarAuto(@Valid Auto auto) {
		autoRepository.save(auto);
		
	}
	/**obtener una lista de autos*/
	public List<Auto> findAll() {
		return autoRepository.findAll();
	}
	
	public Auto buscarId(Long id) {
		return autoRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
	}
	
	public void eliminarPorId(Long id) {
		
		autoRepository.deleteById(id);
	}
	public List<Auto> buscarMarca(String marca) {
		//llamado a un metodo propio
		//return autoRepository.buscarMarca(marca); //Query Tradicional
		return autoRepository.findAllAutoMarca(marca);//Query por objeto
	}

}
