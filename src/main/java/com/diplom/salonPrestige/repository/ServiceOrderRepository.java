package com.diplom.salonPrestige.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplom.salonPrestige.entity.Category;
import com.diplom.salonPrestige.entity.ServiceOrder;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
	
	List<ServiceOrder> findByNameIgnoreCase(String name);

	List<ServiceOrder> findByPrice(float price);

	List<ServiceOrder> findByCategory(Category category);

	
}
