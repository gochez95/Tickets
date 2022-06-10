package com.telus.tickets.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.User;

public interface IUserDao extends CrudRepository<User, Integer> {

	@Query("Select u from User u where u.userName=?1")
	public User findUserByUserName(String userName);
	
//	@Query("Select u from User u where u.idRol.=?1")
	//public List<User> findUserRol(Integer idRol);
	
	@Query("Select u from User u where u.idRole.idRol=?1")
	public List<User> findUserByRol(Integer idRol);
	
}
