package com.telus.tickets.dao;

import org.springframework.data.repository.CrudRepository;

import com.telus.tickets.entity.Status;

public interface IStatusDao extends CrudRepository<Status, Integer> {

}
