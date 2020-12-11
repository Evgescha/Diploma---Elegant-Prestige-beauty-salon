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
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	UserServiceImpl serviceUser;
	@Autowired
	OrderService serviceOrder;
	@Autowired
	CategoryService serviceCategory;
	@Autowired
	ServiceOrderService serviceServiceOrder;
	
	@GetMapping
	@RequestMapping("/11")
	String getMyTender() {
		return "index";
	}
	
	@RequestMapping("/12")
	@GetMapping
	String getMyPreorder() {
		return "index";
	}
	
	@RequestMapping("/13")
	@GetMapping
	String getMyInWork() {
		return "index";
	}
	
	@RequestMapping("/14")
	@GetMapping
	String getMyArhive() {
		return "index";
	}
	
	@RequestMapping("/15")
	@GetMapping
	String getMyResponses() {
		return "index";
	}
	
	
	
	@RequestMapping("/21")
	@PostMapping
	String setResponse() {
		return "index";
	}
	@RequestMapping("/22")
	@PostMapping
	String setWorkEnd() {
		return "index";
	}
	
	

}
