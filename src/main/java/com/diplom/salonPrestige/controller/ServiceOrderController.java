package com.diplom.salonPrestige.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diplom.salonPrestige.entity.Category;
import com.diplom.salonPrestige.entity.ServiceOrder;
import com.diplom.salonPrestige.exception.RecordNotFoundException;
import com.diplom.salonPrestige.service.CategoryService;
import com.diplom.salonPrestige.service.ServiceOrderService;

@Controller
@RequestMapping("/service")
public class ServiceOrderController {

	@Autowired
	ServiceOrderService service;

	@Autowired
	CategoryService serviceCategory;

	@GetMapping
	String getService(Model model) {
		List<ServiceOrder> list = service.repository.findAll();

		if (list == null)
			model.addAttribute("list", null);
		else
			model.addAttribute("list", list);

		return "service-list";
	}

	@RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return "redirect:/service";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String edit(Model model, @PathVariable(name = "id", required = false) Long id, Principal principal)
			throws RecordNotFoundException {

		List<Category> categories = serviceCategory.repository.findAll();

		if (id != null) {
			ServiceOrder entity = service.read(id);
			model.addAttribute("entity", entity);
		} else {
			model.addAttribute("entity", new ServiceOrder());
		}
		model.addAttribute("categories", categories);
		return "service-add-edit";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createOrUpdate(ServiceOrder entity, @Param("catId") Long catId) throws Exception {

		entity.setCategory(serviceCategory.read(catId));
		service.create(entity);
		return "redirect:/service";
	}
}
