package com.diplom.salonPrestige.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diplom.salonPrestige.entity.User;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImpl service;

	@GetMapping
	String getUserList(Model model) {
		List<User> list = service.repository.findAll();
		model.addAttribute("list", list);
		return "user-list";
	}

	@RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return "redirect:/users/";
	}
}
