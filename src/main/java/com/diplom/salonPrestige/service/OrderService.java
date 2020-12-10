package com.diplom.salonPrestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplom.salonPrestige.entity.Order;
import com.diplom.salonPrestige.repository.OrderRepository;

@Service
public class OrderService extends CrudImpl<Order> {

	public OrderRepository repository;

	@Autowired
	public OrderService(OrderRepository repository) {
		super(repository);
		this.repository = repository;
	}

}
