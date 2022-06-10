package com.telus.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telus.tickets.entity.Status;


@Service
public interface IStatusService {
	public List<Status> findAll();
	
	public void save(Status status);
	
	public Status findOne(Integer id);
	
	public void delete(Integer id);
}
