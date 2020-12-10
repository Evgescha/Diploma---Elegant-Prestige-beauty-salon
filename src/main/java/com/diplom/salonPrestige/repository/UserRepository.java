package com.diplom.salonPrestige.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.diplom.salonPrestige.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findByUsernameIgnoreCase(String username);  
    public User findByUsername(String username);
}
