package com.telus.tickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telus.tickets.entity.Category;

@Service
public interface ICategoryService {

	public List<Category> findAll();
	
	public void save(Category category);
	
	public Category findOne(Integer id);
	
	public void delete(Integer id);
	
}
