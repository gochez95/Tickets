package com.telus.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.tickets.dao.IPriorityDao;
import com.telus.tickets.entity.Priority;

@Service
public class PriorityServiceImp implements IPriorityService {

	@Autowired
	private IPriorityDao priorityDao;
	
	@Override
	public List<Priority> findAll() {
		return (List<Priority>)priorityDao.findAll();
	}

	@Override
	public void save(Priority priority) {
		priorityDao.save(priority);
	}

	@Override
	public Priority findOne(Integer id) {
		return priorityDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		priorityDao.deleteById(id);
	}

}
