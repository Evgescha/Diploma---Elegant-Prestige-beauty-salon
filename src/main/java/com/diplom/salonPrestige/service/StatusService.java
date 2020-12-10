package com.diplom.salonPrestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplom.salonPrestige.entity.Status;
import com.diplom.salonPrestige.repository.StatusRepository;

@Service
public class StatusService extends CrudImpl<Status> {

	public StatusRepository repository;

	@Autowired
	public StatusService(StatusRepository repository) {
		super(repository);
		this.repository = repository;
	}
	
}
