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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	OrderService serviceOrder;
	
	@Autowired
	CategoryService serviceCategory;
	
	@Autowired
	ServiceOrderService serviceServiceOrder	;
	
	@Autowired
	UserServiceImpl serviceUser;
	
	@GetMapping
	@RequestMapping("/11")
	String getOrderFromClient() {
		return "index";
	}
	@GetMapping
	@RequestMapping("/12")
	String getAllTender() {
		return "index";
	}
	@GetMapping
	@RequestMapping("/13")
	String getResponsesWorkers() {
		return "index";
	}
	@GetMapping
	@RequestMapping("/14")
	String getPreorder() {
		return "index";
	}
	@GetMapping
	@RequestMapping("/15")
	String getInWork() {
		return "index";
	}
	@GetMapping
	@RequestMapping("/16")
	String getArhive() {
		return "index";
	}
	
	
	@GetMapping
	@RequestMapping("/21")
	String getWorker() {
		return "index";
	}
	
	@GetMapping
	@RequestMapping("/22")
	String getClient() {
		return "index";
	}
	
	
	
	
	
}
