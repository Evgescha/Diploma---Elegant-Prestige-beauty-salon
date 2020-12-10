package com.diplom.salonPrestige.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diplom.salonPrestige.entity.Category;
import com.diplom.salonPrestige.exception.RecordNotFoundException;
import com.diplom.salonPrestige.service.CategoryService;
import com.diplom.salonPrestige.service.OrderService;
import com.diplom.salonPrestige.service.ServiceOrderService;

@Controller
@RequestMapping("/categories")
public class OrderController {

	@Autowired
	OrderService serviceOrder;
	
	@Autowired
	CategoryService serviceCategory;
	
	@Autowired
	ServiceOrderService serviceServiceOrder	;

	@GetMapping
	String get(Model model) {
//		List<Category> list = service.repository.findAll();
//		if (list == null)
//			model.addAttribute("list", null);
//		else
//			model.addAttribute("list", list);
		return "categories-list";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String edit(Model model, @PathVariable(name = "id", required = false) Long id)
			throws RecordNotFoundException {
//		if (id != null) {
//			Category entity = service.read(id);
//			model.addAttribute("entity", entity);
//		} else {
//			model.addAttribute("entity", new Category());
//		}
		return "categories-add-edit";
	}

	@RequestMapping(path = "/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) throws Exception {
//		service.delete(id);
		return "redirect:/categories";
	}

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createOrUpdate(Category entity) throws Exception {
//		service.create(entity);
		return "redirect:/categories";
	}
}
