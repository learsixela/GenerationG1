package com.generation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Licencia;
import com.generation.models.Usuario;
import com.generation.services.LicenciaService;
import com.generation.services.UsuarioService;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {
	@Autowired
	LicenciaService licenciaService;
	
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping("")
	public String depliegue(Model model) {
		Licencia licencia = new Licencia();
		//licencia.setEstado("activo");
		model.addAttribute("licencia", licencia);
		//lista de usuarios
		List<Usuario> listaUsuarios = usuarioService.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		
		return "licencia.jsp";
	}
}
