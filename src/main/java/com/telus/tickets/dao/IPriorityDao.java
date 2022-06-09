package com.telus.tickets.dao;

import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.Priority;

public interface IPriorityDao extends CrudRepository<Priority, Integer> {

}
