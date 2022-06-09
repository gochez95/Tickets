package com.telus.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.tickets.dao.IRolDao;
import com.telus.tickets.entity.Rol;

@Service
public class RolServiceImp implements IRolService {

	@Autowired
	private IRolDao rolDao;
	
	@Override
	public List<Rol> findAll() {
		return (List<Rol>)rolDao.findAll();
	}

	@Override
	public void save(Rol rol) {
		rolDao.save(rol);
	}

	@Override
	public Rol findOne(Integer id) {
		return rolDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		rolDao.deleteById(id);
	}

}
