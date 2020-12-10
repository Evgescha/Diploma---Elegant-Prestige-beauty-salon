package com.diplom.salonPrestige.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplom.salonPrestige.entity.Category;
import com.diplom.salonPrestige.repository.CategoryRepository;

@Service
public class CategoryService extends CrudImpl<Category> {

	public CategoryRepository repository;

	@Autowired
	public CategoryService(CategoryRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Category findByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}

}
