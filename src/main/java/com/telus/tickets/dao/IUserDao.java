package com.telus.tickets.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.User;

public interface IUserDao extends CrudRepository<User, Integer> {

	@Query("Select u from User u where u.userName=?1")
	public User findUserByUserName(String userName);
	
}
