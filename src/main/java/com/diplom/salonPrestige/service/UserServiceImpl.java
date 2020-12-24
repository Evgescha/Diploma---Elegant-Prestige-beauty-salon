package com.diplom.salonPrestige.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diplom.salonPrestige.entity.Role;
import com.diplom.salonPrestige.entity.User;
import com.diplom.salonPrestige.repository.UserRepository;

@Service
public class UserServiceImpl extends CrudImpl<User> {

	private final static String DEFAULT_ROLE = "ROLE_USER";
	private final static String ROLE_ADMIN = "ROLE_ADMIN";
	private final static String ROLE_WORKER = "ROLE_WORKER";
	private final static String ROLE_MANAGER = "ROLE_MANAGER";

	@Autowired
	private RoleServiceImpl roleService;

	public UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public User findByUsername(String username) {
		return repository.findByUsernameIgnoreCase(username);
	}
	

	@Override
	public void update(User entity) throws Exception {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		super.update(entity);
	}

	//registration
	public boolean userRegistration(User entity) {

		if (repository.findByUsernameIgnoreCase(entity.getUsername()) != null)
			return false;
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		try {
			// просто создание
			create(entity);

			// добавление роли и сохранение
			Role role = roleService.findByName(DEFAULT_ROLE);
			entity = repository.findByUsernameIgnoreCase(entity.getUsername());
			entity.getRoles().add(role);
			update(entity);

			// сохранение в списке ролей пользователя
			role.getUsers().add(entity);
			roleService.update(role);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean userCreateWorker(User entity) {

		if (repository.findByUsernameIgnoreCase(entity.getUsername()) != null)
			return false;
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		try {
			// просто создание
			create(entity);

			// добавление роли и сохранение
			Role role = roleService.findByName(ROLE_WORKER);
			entity = repository.findByUsernameIgnoreCase(entity.getUsername());
			entity.getRoles().add(role);
			update(entity);

			// сохранение в списке ролей пользователя
			role.getUsers().add(entity);
			roleService.update(role);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean userCreateManager(User entity) {

		if (repository.findByUsernameIgnoreCase(entity.getUsername()) != null)
			return false;
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		try {
			// просто создание
			create(entity);

			// добавление роли и сохранение
			Role role = roleService.findByName(ROLE_MANAGER);
			entity = repository.findByUsernameIgnoreCase(entity.getUsername());
			entity.getRoles().add(role);
			update(entity);

			// сохранение в списке ролей пользователя
			role.getUsers().add(entity);
			roleService.update(role);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
