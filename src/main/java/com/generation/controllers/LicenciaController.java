package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Licencia;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {

	@RequestMapping("")
	public String depliegue(Model model) {
		Licencia licencia = new Licencia();
		//licencia.setEstado("activo");
		model.addAttribute("licencia", licencia);
		return "licencia.jsp";
	}
}
