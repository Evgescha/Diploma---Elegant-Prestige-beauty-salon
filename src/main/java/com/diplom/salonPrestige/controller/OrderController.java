package com.diplom.salonPrestige.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.diplom.salonPrestige.entity.Order;
import com.diplom.salonPrestige.entity.Role;
import com.diplom.salonPrestige.entity.User;
import com.diplom.salonPrestige.exception.RecordNotFoundException;
import com.diplom.salonPrestige.service.OrderService;
import com.diplom.salonPrestige.service.RoleServiceImpl;
import com.diplom.salonPrestige.service.ServiceOrderService;
import com.diplom.salonPrestige.service.StatusService;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;
	
	
	@Autowired
	ServiceOrderService serviceServiceOrder	;
	
	@Autowired
	UserServiceImpl serviceUser;
	
	@Autowired
	RoleServiceImpl serviceRole;
	
	@Autowired
	StatusService serviceStatus;

	@GetMapping
	String get(Model model) {
		List<Order> list = service.repository.findAll();
		if (list == null)
			model.addAttribute("list", null);
		else
			model.addAttribute("list", list);
		return "order-list";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String edit(Model model, @PathVariable(name = "id", required = false) Long id)
			throws RecordNotFoundException {
		if (id != null) {
			Order entity = service.read(id);
			model.addAttribute("entity", entity);
		} else {
			model.addAttribute("entity", new Order());
		}
		
		model.addAttribute("users", getOnluUser());
		model.addAttribute("workers", getOnluWorker());
		model.addAttribute("statuses", serviceStatus.repository.findAll());
		model.addAttribute("services",serviceServiceOrder.repository.findAll() );
		
		return "order-add-edit";
	}
	private List<User> getOnluUser() {
		List<User> list1 = serviceUser.repository.findAll();
		List<User> list = new ArrayList<User>();
		Role role = serviceRole.findByName("ROLE_USER");
		for (int i = list1.size() - 1; i >= 0; i--) {
			if (list1.get(i).getRoles().contains(role))
				list.add(list1.get(i));
		}
		return list;
	}
	
	private List<User> getOnluWorker() {
		List<User> list1 = serviceUser.repository.findAll();
		List<User> list = new ArrayList<User>();
		Role role = serviceRole.findByName("ROLE_WORKER");
		for (int i = list1.size() - 1; i >= 0; i--) {
			if (list1.get(i).getRoles().contains(role))
				list.add(list1.get(i));
		}
		return list;
	}

	@RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return "redirect:/order";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createOrUpdate(Order entity,
			@RequestParam("userId") Long userId,
			@RequestParam("serviceId") Long serviceId,
			@RequestParam("workerId") Long workerId,
			@RequestParam("statusId") Long statusId
			) throws Exception {
		
		entity.setCreator(serviceUser.read(userId));
		entity.setService(serviceServiceOrder.read(serviceId));
		entity.setWorker(serviceUser.read(workerId));
		entity.setStatus(serviceStatus.read(statusId));
		service.create(entity);
		return "redirect:/order";
	}
}
