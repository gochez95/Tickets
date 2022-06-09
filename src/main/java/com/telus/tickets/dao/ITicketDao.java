package com.telus.tickets.dao;

import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.Ticket;

public interface ITicketDao extends CrudRepository<Ticket, Integer> {

}
