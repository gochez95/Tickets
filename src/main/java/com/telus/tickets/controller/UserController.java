package com.telus.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value = "/createUser")
	public String createUser() {
		
		return "user/createUser";
	}
	
}