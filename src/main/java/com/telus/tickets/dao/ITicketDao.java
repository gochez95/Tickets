package com.telus.tickets.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.Ticket;

public interface ITicketDao extends CrudRepository<Ticket, Integer> {

	@Query("Select t from Ticket t where t.assign.idUser=?1")
	public List<Ticket> findTicketsByAssign(Integer idAssign);
	
	
	@Query("Select t from Ticket t where t.idUser.idUser=?1")
	public List<Ticket> findTicketsByUser(Integer idUser);
}
