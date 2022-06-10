package com.telus.tickets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telus.tickets.entity.Ticket;
import com.telus.tickets.entity.User;
import com.telus.tickets.service.TicketServiceImp;
import com.telus.tickets.service.UserServiceImp;

@Controller
public class TicketController {

	@Autowired
	private UserServiceImp userService;
	
	@Autowired
	private TicketServiceImp ticketService;
	
	@RequestMapping(value = { "/", "/tickets" })
	public String ticket(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		User user= new User();
		user=userService.findUserbyUserName(userName);
		model.addAttribute("rol", user.getIdRole().getNameRol());
		return "ticket/tickets";
	}
	
	
	@RequestMapping(value = "/tickets/create")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "ticket/createTicket";
	}
	
	@PostMapping(value = "/tickets/create")
	public String saveTicket(Ticket ticket,Model model) {
		ticketService.save(ticket);
		return "ticket/createTicket";
	}

}
