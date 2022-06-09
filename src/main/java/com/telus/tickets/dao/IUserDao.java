package com.telus.tickets.dao;

import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.User;

public interface IUserDao extends CrudRepository<User, Integer> {

}
