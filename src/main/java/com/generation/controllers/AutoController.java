package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Auto;
import com.generation.services.AutoService;

@Controller
@RequestMapping("/auto")
public class AutoController {
	@Autowired
	AutoService autoService;
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("auto") Auto auto) {
		
		return "auto.jsp";
	}
	
	@PostMapping("/guardar")
	public String guardarAuto(@Valid @ModelAttribute("auto") Auto auto,
			BindingResult resultado,
			Model model) {
		
		
		if(resultado.hasErrors()) {
			model.addAttribute("msgError","Datos erroneos");
			return "autos.jsp";
		}else {
			//enviamos el obeto a persistir en base datos
			autoService.guardarAuto(auto);
			//obtener un alista de autos
			List<Auto> listaAutos = autoService.findAll();
			//pasamos la lista de autos al jsp
			model.addAttribute("autosCapturados", listaAutos);
			return "mostrarAutos.jsp";
		}
		
		
	}

}
