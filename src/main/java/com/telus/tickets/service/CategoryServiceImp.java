package com.telus.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.tickets.dao.ICategoryDao;
import com.telus.tickets.entity.Category;

@Service
public class CategoryServiceImp implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	public List<Category> findAll() {
		return (List<Category>)categoryDao.findAll();
	}

	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}

	@Override
	public Category findOne(Integer id) {
		return categoryDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		categoryDao.deleteById(id);
	}

}
