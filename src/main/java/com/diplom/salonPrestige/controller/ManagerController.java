package com.diplom.salonPrestige.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diplom.salonPrestige.entity.Role;
import com.diplom.salonPrestige.entity.User;
import com.diplom.salonPrestige.service.CategoryService;
import com.diplom.salonPrestige.service.OrderService;
import com.diplom.salonPrestige.service.RoleServiceImpl;
import com.diplom.salonPrestige.service.ServiceOrderService;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping("/managers")
public class ManagerController {

	@Autowired
	UserServiceImpl serviceUser;
	@Autowired
	OrderService serviceOrder;
	@Autowired
	CategoryService serviceCategory;
	@Autowired
	ServiceOrderService serviceServiceOrder;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	final String ROLE = "ROLE_MANAGER";

	@Autowired
	UserServiceImpl service;

	@Autowired
	RoleServiceImpl serviceRole;

	@GetMapping
	String getUserList(Model model) {

		model.addAttribute("list", getOnluUserWithRole());
		return "manager-list";
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
		return "redirect:/managers";
	}
	
	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String edit(Model model, @PathVariable(name="id",required = false) Long id)  {
		if (id!=null) {
			User entity = service.read(id);
			model.addAttribute("entity", entity);
		} else {
			model.addAttribute("entity", new User());
		}
		return "manager-add-edit";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createOrUpdate(User entity,RedirectAttributes redirectAttributes) throws Exception {
		if(entity.getId()==null) {
			boolean success = service.userCreateManager(entity);
			String response = success ? "Менеджер успешно добавлен" : "Ошибка добавления менеджера. Попробуйте позже или проверьте уникальность логина.";
			redirectAttributes.addFlashAttribute("success", response);
		}
		else {
			User read = service.read(entity.getId());
			read.update(entity.getUsername(), entity.getPassword(), entity.getFio(), entity.getAdres(), entity.getPhone(), entity.getDateBorn());
			read.setPassword(passwordEncoder.encode(read.getPassword()));
			service.update(read);
		}
		return "redirect:/managers";
	}
	

}
