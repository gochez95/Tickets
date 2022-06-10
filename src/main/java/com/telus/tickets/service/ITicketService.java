package com.telus.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telus.tickets.entity.Ticket;


@Service
public interface ITicketService {

	public List<Ticket> findAll();
	
	public void save(Ticket ticket);
	
	public Ticket findOne(Integer id);
	
	public void delete(Integer id);
	
	public List<Ticket> findTicketsByIdAssign(Integer idAssign);
	
	public List<Ticket> findTicketsByIdUser(Integer idUser);

}
