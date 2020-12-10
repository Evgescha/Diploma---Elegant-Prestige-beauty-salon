package com.diplom.salonPrestige.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diplom.salonPrestige.entity.ServiceOrder;
import com.diplom.salonPrestige.exception.RecordNotFoundException;
import com.diplom.salonPrestige.service.ServiceOrderService;

@Controller
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	ServiceOrderService service;

	

	@GetMapping
	String getService(Model model) {
//		List<Service> list = service.repository.findAll();
//
//		if (list == null)
//			model.addAttribute("list", null);
//		else
//			model.addAttribute("list", list);
//
		return "service";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String edit(Model model, @PathVariable(name = "id", required = false) Long id, Principal principal)
			throws RecordNotFoundException {
//
//		List<Category> categories = serviceCategory.repository.findAll();
//		List<Platform> platforms = servicePlatform.repository.findAll();
//		List<User> users = serviceUser.repository.findAll();
//		if (id != null) {
//			Service entity = service.read(id);
//			model.addAttribute("entity", entity);
//		} else {
//			model.addAttribute("entity", new Service());
//		}
//		model.addAttribute("categories", categories);
//		model.addAttribute("platforms", platforms);
//		model.addAttribute("users", users);
		return "webinaries-add-edit";
	}

	@RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return "redirect:/webinaries";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createOrUpdate(ServiceOrder entity, @Param("categoryId") Long categoryId,
			@Param("platformId") Long platformId, @Param("creatorId") Long creatorId, @Param("timeStr") String timeStr)
			throws Exception {
//
//		entity.setPlatform(servicePlatform.read(platformId));
//		entity.setCategory(serviceCategory.read(categoryId));
//		entity.setCreator(serviceUser.read(creatorId));
//		try {
//		entity.setTimes(Time.valueOf(timeStr + ":00"));
//		}catch (Exception e) {
//			entity.setTimes(Time.valueOf(timeStr));
//		}
//		service.create(entity);
		return "redirect:/webinaries";
	}
}
