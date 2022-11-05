package com.rrs.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.rrs.entity.BookOnTape;
import com.rrs.service.implement.BookOnTapeServiceImpl;

@Controller
@RequestMapping("/home/book-on-tape")
public class BookOnTapeController {
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpSession session;
	@Autowired
	BookOnTapeServiceImpl bOnTapeServiceImpl;
	@Autowired
	BookOnTape bookConstructor;
	
//	 show list BookOnTape
	@GetMapping()
	public String showBookOnTape(
			Model model
	) {
		List<BookOnTape> bookOnTapes = bOnTapeServiceImpl.getAll();
		model.addAttribute("bookOnTapes", bookOnTapes);
		model.addAttribute("BookOnTapeDTO", bookConstructor);
		return "bookOnTape";
	}
	
//	 show form update? delete? by action
	@GetMapping("/edit")
	public String edit(Model model ) {
		String action = req.getParameter("action");
		Long id = Long.parseLong(req.getParameter("id"));
		
		switch (action) {
			case "update" :
				BookOnTape bOnTape = bOnTapeServiceImpl.getById(id);
				List<BookOnTape> bookOnTapes = bOnTapeServiceImpl.getAll();
				model.addAttribute("BookOnTapeDTO", bOnTape);
				model.addAttribute("bookOnTapes", bookOnTapes);
				return "bookOnTape";
			case "delete" :
				bOnTapeServiceImpl.delete(id);
				List<BookOnTape> listBook = bOnTapeServiceImpl.getAll();
				model.addAttribute("BookOnTapeDTO", bookConstructor);
				model.addAttribute("bookOnTapes", listBook);
				return "redirect:/home/book-on-tape";
			default:
				break;
		}
		return "redirect:/home/book-on-tape";
	}
	
//	save and update
	@PostMapping("/save")
	public String saveBook(
			Model model,
			@Valid @ModelAttribute("BookOnTapeDTO") BookOnTape bookDTO,
			BindingResult result
	) {
		List<BookOnTape> listBook = bOnTapeServiceImpl.getAll();
//		empty validate 
		if(result.hasErrors()) {
			model.addAttribute("BookOnTapeDTO", bookDTO);
			model.addAttribute("bookOnTapes", listBook);
			return "bookOnTape";
		}
//		Id == null -> insert 
// 		id !-= null -> update
		if(bookDTO.getId() == null) {
			for (BookOnTape book : listBook) {
//				check if the serial number exists
				if(bookDTO.getSeri().equals(book.getSeri())) {
					model.addAttribute("BookOnTapeDTO", bookDTO);
					model.addAttribute("bookOnTapes", listBook);
					session.setAttribute("msgBook", "This serial number already exists!");
					return "bookOnTape";
				}
			}
		}
		bOnTapeServiceImpl.add(bookDTO);
		return "redirect:/home/book-on-tape";
	}
	
//	find BookOnTape by Serial Number
	@GetMapping("/searchBook")
	public String searchBook(
			@ModelAttribute("seri") Long seriNumber,
			Model model
	) {
		List<BookOnTape> bookOnTapes = new ArrayList<>();
		BookOnTape bookSeri = bOnTapeServiceImpl.getBySeri(seriNumber);
		if(bookSeri != null) {
			bookOnTapes.add(bookSeri);
			model.addAttribute("BookOnTapeDTO", bookSeri);
		} else {
			session.setAttribute("msgBook", "This serial number does not exist!");
			model.addAttribute("BookOnTapeDTO", bookConstructor);
		}
		model.addAttribute("bookOnTapes", bookOnTapes);
		model.addAttribute("seri", seriNumber);
		return "bookOnTape";
	}
}
