package com.diplom.salonPrestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplom.salonPrestige.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByNameIgnoreCase(String name);
}
