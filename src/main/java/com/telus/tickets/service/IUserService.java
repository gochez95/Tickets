package com.telus.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telus.tickets.entity.User;


@Service
public interface IUserService {

	public List<User> findAll();
	
	public void save(User user);
	
	public User findOne(Integer id);
	
	public void delete(Integer id);
	
	public User findUserbyUserName(String userName);
	
	public List<User> findUserByRol(Integer idRol);
	
}
