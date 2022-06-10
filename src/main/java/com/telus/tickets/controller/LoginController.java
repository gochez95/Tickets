package com.telus.tickets.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@Autowired
	UserController controller;

	@GetMapping("/login")
	public String login(Model model, Principal principal, RedirectAttributes flash, 
			@RequestParam(value="error", required = false) String error) {
		if(principal!=null) {
			flash.addFlashAttribute("info", "Ya ha iniciado Sesión");
			return "redirect:/";
		}
		
		if(error!=null) {
			model.addAttribute("error", "Error en el login, nombre de usuario o contraseña son incorrectos");
			
		}
		model.addAttribute("success", controller.getSuccess());
		controller.setSuccess(false);
		return "login";
	}
	
}
