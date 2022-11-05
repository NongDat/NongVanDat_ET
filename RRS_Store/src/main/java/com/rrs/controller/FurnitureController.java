package com.rrs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrs.entity.Furniture;
import com.rrs.service.implement.FurnitureServiceImpl;

@Controller
@RequestMapping("/home/furniture")
public class FurnitureController {
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpSession session;
	@Autowired
	FurnitureServiceImpl furnitureServiceImpl;
	@Autowired
	Furniture furnitureContructor;
//	 show list Furniture
	@GetMapping()
	public String showFurniture(Model model) {
		List<Furniture> furnitures = furnitureServiceImpl.getAll();
		model.addAttribute("furnitures", furnitures);
		model.addAttribute("FurnitureDTO", furnitureContructor);
		return "furniture";
	}
	
//	 show form update? delete? by action 
	@GetMapping("/edit")
	public String edit(Model model ) {
		String action = req.getParameter("action");
		Long id = Long.parseLong(req.getParameter("id"));
		
		switch (action) {
			case "update" :
				Furniture furniture = furnitureServiceImpl.getById(id);
				List<Furniture> listFurnitures = furnitureServiceImpl.getAll();
				model.addAttribute("furnitures", listFurnitures);
				model.addAttribute("FurnitureDTO", furniture);
				return "furniture";
			case "delete" :
				furnitureServiceImpl.delete(id);
				List<Furniture> listFurnitureDel = furnitureServiceImpl.getAll();
				model.addAttribute("furnitures", listFurnitureDel);
				model.addAttribute("FurnitureDTO", furnitureContructor);
				return "redirect:/home/furniture";
			default:
				break;
		}
		return "redirect:/home/furniture";
	}
	
//	save and update
	@PostMapping("/save")
	public String save(
			Model model,
			@Valid @ModelAttribute("FurnitureDTO") Furniture furnitureDTO,
			BindingResult result
	) {
		List<Furniture> listFurnitures = furnitureServiceImpl.getAll();
//		empty validate 
		if(result.hasErrors()) {
			model.addAttribute("furnitures", listFurnitures);
			model.addAttribute("FurnitureDTO", furnitureDTO);
			return "furniture";
		}
//		Id == null -> insert 
//		id !-= null -> update
		if(furnitureDTO.getId() == null) {
			for (Furniture furniture : listFurnitures) {
//				check if the serial number exists
				if(furnitureDTO.getSeri().equals(furniture.getSeri())) {
					model.addAttribute("FurnitureDTO", furniture);
					model.addAttribute("furnitures", listFurnitures);
					session.setAttribute("msgFurniture", "This serial number already exists!");
					return "furniture";
				}
			}
		}
		
		furnitureServiceImpl.add(furnitureDTO);
		return "redirect:/home/furniture";
	}
	
//	find furniture by Serial Number
	@GetMapping("/search-furniture")
	public String searchBySeri(
			Model model,
			@ModelAttribute("seri") Long seriNumber
			) {
		List<Furniture> furnitures = new ArrayList<>();
		Furniture furnitureSeri = furnitureServiceImpl.getBySeri(seriNumber);
		if(furnitureSeri != null) {
			furnitures.add(furnitureSeri);
			model.addAttribute("FurnitureDTO", furnitureSeri);
		} else {
			session.setAttribute("msgFurniture", "This serial number does not exist!");
			model.addAttribute("FurnitureDTO", furnitureContructor);
		}
		model.addAttribute("furnitures", furnitures);
		model.addAttribute("seri", seriNumber);
		return "furniture";
	}
}
