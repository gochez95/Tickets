package com.telus.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.tickets.dao.ITicketDao;
import com.telus.tickets.entity.Ticket;

@Service
public class TicketCommentServiceImp implements ITicketService{

	@Autowired
	private ITicketDao ticketDao;
	
	@Override
	public List<Ticket> findAll() {
		return (List<Ticket>)ticketDao.findAll();
	}

	@Override
	public void save(Ticket ticket) {
		ticketDao.save(ticket);
	}

	@Override
	public Ticket findOne(Integer id) {
		return ticketDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		ticketDao.deleteById(id);
	}

}
