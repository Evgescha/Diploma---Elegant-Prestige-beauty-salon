package com.diplom.salonPrestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diplom.salonPrestige.service.CategoryService;
import com.diplom.salonPrestige.service.OrderService;
import com.diplom.salonPrestige.service.ServiceOrderService;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl serviceUser;
	@Autowired
	OrderService serviceOrder;
	@Autowired
	CategoryService serviceCategory;
	@Autowired
	ServiceOrderService serviceServiceOrder;
	
	@GetMapping
	String getUsers() {
		return "index";
	}

}
