package com.diplom.salonPrestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diplom.salonPrestige.service.RoleServiceImpl;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping(path = { "/", "/index" })
public class IndexController {

	@Autowired
	UserServiceImpl serviceUser;
	@Autowired
	RoleServiceImpl serviceRole;
	
	
	@GetMapping
	String getIndex() {
		return "index";
	}

}
