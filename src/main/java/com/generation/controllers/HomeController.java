package com.generation.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(HttpSession session) {
		
		String email = session.getAttribute("email").toString();
		if(email != null || ! email.isEmpty()) {
			return "home.jsp";
		}
		
		return "redirect:/registro/usuario/login";
	}

}
