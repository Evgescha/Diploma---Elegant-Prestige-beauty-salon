package com.diplom.salonPrestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diplom.salonPrestige.service.CategoryService;
import com.diplom.salonPrestige.service.OrderService;
import com.diplom.salonPrestige.service.ServiceOrderService;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	UserServiceImpl serviceUser;
	@Autowired
	OrderService serviceOrder;
	@Autowired
	CategoryService serviceCategory;
	@Autowired
	ServiceOrderService serviceServiceOrder;

	@RequestMapping("/11")
	@GetMapping
	String getMyOrder() {
		return "index";
	}
	@RequestMapping("/12")
	@GetMapping
	String getMyArhive() {
		return "index";
	}
	@RequestMapping("/13")
	@GetMapping
	String GetNewOrder() {
		return "index";
	}
	@RequestMapping("/14")
	@PostMapping
	String setNewOrder() {
		return "index";
	}
	

}
