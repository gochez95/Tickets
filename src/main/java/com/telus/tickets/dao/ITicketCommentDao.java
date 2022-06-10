package com.telus.tickets.dao;

import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.TicketComment;

public interface ITicketCommentDao extends CrudRepository<TicketComment, Integer>{

}
