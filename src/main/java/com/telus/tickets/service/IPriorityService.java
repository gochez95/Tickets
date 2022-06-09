package com.telus.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telus.tickets.entity.Priority;

@Service
public interface IPriorityService  {

	public List<Priority> findAll();
	
	public void save(Priority priority);
	
	public Priority findOne(Integer id);
	
	public void delete(Integer id);
	
}
