package com.diplom.salonPrestige.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diplom.salonPrestige.entity.Role;
import com.diplom.salonPrestige.entity.User;
import com.diplom.salonPrestige.service.RoleServiceImpl;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

	final String ROLE = "ROLE_USER";

	@Autowired
	UserServiceImpl service;

	@Autowired
	RoleServiceImpl serviceRole;

	@GetMapping
	String getUserList(Model model) {

		model.addAttribute("list", getOnluUserWithRole());
		return "user-list";
	}

	private List<User> getOnluUserWithRole() {
		List<User> list1 = service.repository.findAll();
		List<User> list = new ArrayList<User>();
		Role role = serviceRole.findByName(ROLE);
		for (int i = list1.size() - 1; i >= 0; i--) {
			if (list1.get(i).getRoles().contains(role))
				list.add(list1.get(i));
		}
		return list;
	}

	@RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return "redirect:/users/";
	}
}
