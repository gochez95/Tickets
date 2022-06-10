package com.telus.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telus.tickets.entity.Category;
import com.telus.tickets.entity.Priority;
import com.telus.tickets.entity.Ticket;
import com.telus.tickets.entity.User;
import com.telus.tickets.service.CategoryServiceImp;
import com.telus.tickets.service.PriorityServiceImp;
import com.telus.tickets.service.StatusServiceImp;
import com.telus.tickets.service.TicketServiceImp;
import com.telus.tickets.service.UserServiceImp;

import ch.qos.logback.core.status.Status;

@Controller
public class TicketController {

	@Autowired
	private UserServiceImp userService;

	@Autowired
	private TicketServiceImp ticketService;

	@Autowired
	private CategoryServiceImp categoryService;

	@Autowired
	private PriorityServiceImp priorityService;

	@Autowired
	private StatusServiceImp statusService;

	@RequestMapping(value = { "/", "/tickets" })
	public String ticket(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		User user = new User();
		user = userService.findUserbyUserName(userName);
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
	public String saveTicket(Ticket ticket, Model model) {
		if (ticket.getIdTicket() == null) {
			int size = ticketService.findAll().size();
			ticket.setIdTicket(size + 1);
		}
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		User user = new User();
		user = userService.findUserbyUserName(userName);
		ticket.setIdUser(user);
		ticketService.save(ticket);
		return "redirect:/";
	}

	@PostMapping(value = "/tickets/edit")
	public String editTicket(Ticket ticket, Model model) {
		ticketService.save(ticket);
		return "redirect:/";
	}

	@RequestMapping("tickets/manageTicket")
	public String manageTicket(Model model) {
		List<Ticket> tickets;
		tickets = ticketService.findAll();
		model.addAttribute("tickets", tickets);
		return "ticket/manageTicket";
	}

	@RequestMapping("tickets/manageTicket/{id}")
	public String assingTicket(@PathVariable(value = "id") int id, Model model) {
		Ticket ticketAssing;
		List<Category> category = new ArrayList<>();
		List<Priority> priority = new ArrayList<>();
		List<User> users = new ArrayList<>();
		category = categoryService.findAll();
		priority = priorityService.findAll();
		users = userService.findUserByRol(2);
		if (id != 0 && id > 0) {
			ticketAssing = ticketService.findOne(id);
			model.addAttribute("ticket", ticketAssing);
			model.addAttribute("category", category);
			model.addAttribute("priority", priority);
			model.addAttribute("users", users);

		}
		return "ticket/editTicket";
	}

	@RequestMapping("/tickets/myTickets")
	public String myTickets(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		User user = userService.findUserbyUserName(userName);
		List<Ticket> myTickets = new ArrayList<>();
		myTickets = ticketService.findTicketsByIdAssign(user.getIdUser());
		model.addAttribute("myTickets", myTickets);
		return "ticket/myTickets";
	}

	@RequestMapping("tickets/myTickets/{id}")
	public String editMyTickets(@PathVariable(value = "id") int id, Model model) {
		Ticket ticketAssing;
		List<Category> category = new ArrayList<>();
		List<Priority> priority = new ArrayList<>();
		List<com.telus.tickets.entity.Status> status = new ArrayList<>();
		List<User> users = new ArrayList<>();
		category = categoryService.findAll();
		priority = priorityService.findAll();
		users = userService.findUserByRol(2);
		status=statusService.findAll();
		if (id != 0 && id > 0) {
			ticketAssing = ticketService.findOne(id);
			model.addAttribute("ticket", ticketAssing);
			model.addAttribute("category", category);
			model.addAttribute("priority", priority);
			model.addAttribute("users", users);
			model.addAttribute("status", status);
		}
		return "ticket/editMyTicket";

	}
	
	@RequestMapping("tickets/track")
	public String trackTicket(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		User user= userService.findUserbyUserName(userName);
		List<Ticket> ticket = new ArrayList<>();
		ticket=ticketService.findTicketsByIdUser(user.getIdUser());
		model.addAttribute("track", ticket);
		return "ticket/trackTicket";
	}

}
