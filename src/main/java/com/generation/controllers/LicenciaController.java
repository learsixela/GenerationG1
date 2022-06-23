package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {

	@RequestMapping("")
	public String depliegue() {
		return "licencia.jsp";
	}
}
