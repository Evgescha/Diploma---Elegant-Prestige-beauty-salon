package com.diplom.salonPrestige.controller;

import java.security.Principal;
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
import com.diplom.salonPrestige.entity.ServiceOrder;
import com.diplom.salonPrestige.entity.User;
import com.diplom.salonPrestige.service.OrderService;
import com.diplom.salonPrestige.service.RoleServiceImpl;
import com.diplom.salonPrestige.service.ServiceOrderService;
import com.diplom.salonPrestige.service.StatusService;
import com.diplom.salonPrestige.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

	final String ROLE = "ROLE_USER";

	@Autowired
	UserServiceImpl service;

	@Autowired
	OrderService serviceOrder;

	@Autowired
	ServiceOrderService serviceServiceOrder;

	@Autowired
	UserServiceImpl serviceUser;

	@Autowired
	RoleServiceImpl serviceRole;

	@Autowired
	StatusService serviceStatus;

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

	@RequestMapping(path = "/createOrder")
	public String createOrder(Model model, Principal princopal) throws Exception {

		User entity = service.findByUsername(princopal.getName());
		model.addAttribute("entity", entity);
		model.addAttribute("services", serviceServiceOrder.repository.findAll());

		return "userOrder-add-edit";
	}

	@RequestMapping(path = "/createOrderNow", method = RequestMethod.POST)
	public String createOrder(Order entity, @RequestParam("serviceId") Long serviceId, Principal principal)
			throws Exception {

		User creator = service.findByUsername(principal.getName());
		ServiceOrder servic = serviceServiceOrder.read(serviceId);
		entity.setCreator(creator);
		entity.setService(servic);
		entity.setWorker(null);
		entity.setStatus(serviceStatus.repository.findByName("Предзаказ"));

		serviceOrder.create(entity);
		Order order = serviceOrder.repository.findByCreatorAndServiceAndDateCreatedAndDateEnded(creator, servic,
				entity.getDateCreated(), entity.getDateEnded());
		creator.getMyOrders().add(order);
		service.update(creator);

		return "redirect:/users/myOrder";
	}

	@RequestMapping(path = "/myOrder")
	public String myOrder(Model model, Principal principal) throws Exception {
		User user = service.findByUsername(principal.getName());
		List<Order> myOrders = user.getMyOrders();
		for (int i = myOrders.size() - 1; i >= 0; i--)
			if (myOrders.get(i).getStatus().getId() == 5)
				myOrders.remove(i);
		model.addAttribute("list", myOrders);
		return "orderToUser";
	}

	@RequestMapping(path = "/myArhive")
	public String myArhive(Model model, Principal principal) throws Exception {
		User user = service.findByUsername(principal.getName());
		List<Order> myOrders = user.getMyOrders();
		for (int i = myOrders.size() - 1; i >= 0; i--)
			if (myOrders.get(i).getStatus().getId() != 5)
				myOrders.remove(i);
		model.addAttribute("list", myOrders);
		return "orderToUser";
	}
}
