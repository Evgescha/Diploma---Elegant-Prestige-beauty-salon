package com.diplom.salonPrestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplom.salonPrestige.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
	Status findByName(String name);
}
