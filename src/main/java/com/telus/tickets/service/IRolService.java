package com.telus.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telus.tickets.entity.Rol;


@Service
public interface IRolService {
	public List<Rol> findAll();
	
	public void save(Rol rol);
	
	public Rol findOne(Integer id);
	
	public void delete(Integer id);
}
