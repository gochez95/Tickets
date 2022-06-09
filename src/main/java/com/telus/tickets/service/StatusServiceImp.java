package com.telus.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.tickets.dao.IStatusDao;
import com.telus.tickets.entity.Status;

@Service
public class StatusServiceImp implements IStatusService {

	@Autowired
	private IStatusDao statusDao;
	
	@Override
	public List<Status> findAll() {
		return (List<Status>)statusDao.findAll();
	}

	@Override
	public void save(Status status) {
		statusDao.save(status);
	}

	@Override
	public Status findOne(Integer id) {
		return statusDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		statusDao.deleteById(id);
	}

}
