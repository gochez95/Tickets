package com.telus.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.tickets.dao.IUserDao;
import com.telus.tickets.entity.User;

@Service
public class UserServiceImp implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public User findOne(Integer id) {
		return userDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		userDao.deleteById(id);
	}

	@Override
	public User findUserbyUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	
	

}
