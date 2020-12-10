package com.diplom.salonPrestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplom.salonPrestige.entity.ServiceOrder;
import com.diplom.salonPrestige.repository.ServiceOrderRepository;

@Service
public class ServiceOrderService extends CrudImpl<ServiceOrder> {

	public ServiceOrderRepository repository;

	@Autowired
	public ServiceOrderService(ServiceOrderRepository repository) {
		super(repository);
		this.repository = repository;
	}


}
