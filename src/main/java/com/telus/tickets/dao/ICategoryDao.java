package com.telus.tickets.dao;

import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.Category;

public interface ICategoryDao extends CrudRepository<Category, Integer> {

}
