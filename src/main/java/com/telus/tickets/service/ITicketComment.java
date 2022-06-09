package com.telus.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telus.tickets.entity.TicketComment;


@Service
public interface ITicketComment{

	public List<TicketComment> findAll();
	
	public void save(TicketComment ticketComment);
	
	public TicketComment findOne(Integer id);
	
	public void delete(Integer id);
	
}
