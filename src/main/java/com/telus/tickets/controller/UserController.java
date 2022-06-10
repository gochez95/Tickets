package com.telus.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.telus.tickets.entity.Rol;
import com.telus.tickets.entity.User;
import com.telus.tickets.service.UserServiceImp;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private Boolean success=false;

	@RequestMapping(value = "/createUser")
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/createUser";
	}
	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String guardarUsuario(@Validated User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/createUser";
		}
		if (verificacionPassword(user)) {

			if (verificarUser(user) == false) {
				System.out.println("Entro");
				user.setPassword(Encoder(user.getPassword()));
				Rol rol = new Rol(3);
				user.setIdRole(rol);
				user.setActive(true);
				userService.save(user);
				success=true;
				return "redirect:/login";
			}else {
				model.addAttribute("existUser", true);
			}
		}else {
			model.addAttribute("confirmPassword", false);

		}
		success=false;
		return "user/createUser";
	}
	
	
	public boolean verificacionPassword(User user) {
		if (user.getPassword().equals(user.getConfirmePassword())) {
			return true;
		}
		return false;
	}
	
	public boolean verificarUser(User user) {
		List<User> listaUsuario = new ArrayList<>();
		listaUsuario = userService.findAll();
		for (int i = 0; i < listaUsuario.size(); i++) {
			if (listaUsuario.get(i).getUserName().equals(user.getUserName())) {
				return true;
			}
		}
		return false;

	}
	
	public String Encoder(String contrasenia) {
		if (!contrasenia.isEmpty() && contrasenia != null) {
			String BcrypPass = passwordEncoder.encode(contrasenia);
			return BcrypPass;
		}
		return "";
	}


	public Boolean getSuccess() {
		return success;
	}


	public void setSuccess(Boolean success) {
		this.success = success;
	}

	
	
}
