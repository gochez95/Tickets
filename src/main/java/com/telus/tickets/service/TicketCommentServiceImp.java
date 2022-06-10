package com.telus.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.tickets.dao.ITicketCommentDao;
import com.telus.tickets.dao.ITicketDao;
import com.telus.tickets.entity.Ticket;
import com.telus.tickets.entity.TicketComment;

@Service
public class TicketCommentServiceImp implements ITicketComment{

	@Autowired
	private ITicketCommentDao ticketDao;

	@Override
	public List<TicketComment> findAll() {
		return (List<TicketComment>)ticketDao.findAll();
	}

	@Override
	public void save(TicketComment ticketComment) {
		ticketDao.save(ticketComment);
	}

	@Override
	public TicketComment findOne(Integer id) {
		return ticketDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		ticketDao.deleteById(id);
	}
	
	


}
