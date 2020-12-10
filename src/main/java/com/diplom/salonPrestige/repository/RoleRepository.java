package com.diplom.salonPrestige.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplom.salonPrestige.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByNameIgnoreCase(String login);  
}
