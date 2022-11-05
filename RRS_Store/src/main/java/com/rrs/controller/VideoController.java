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

import com.rrs.entity.Video;
import com.rrs.service.implement.VideoServiceImpl;

@Controller
@RequestMapping("/home")
public class VideoController {
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpSession session;
	@Autowired
	VideoServiceImpl videoServiceImpl;
	@Autowired
	Video videoContructor;
	
//	 show list video
	@GetMapping("/video")
	public String showVideo(Model model) {
		List<Video> listVideo = videoServiceImpl.getAll();
		model.addAttribute("VideoDTO", videoContructor);
		model.addAttribute("videos", listVideo);
		return "video";
	}

//	 show form update? delete? by action
	@GetMapping("/video/edit")
	public String edit(Model model) {
		String action = req.getParameter("action");
		Long id = Long.parseLong(req.getParameter("id"));

		switch (action) {
			case "update":
				Video video = videoServiceImpl.getById(id);
				List<Video> listVideo = videoServiceImpl.getAll();
				model.addAttribute("VideoDTO", video);
				model.addAttribute("videos", listVideo);
				return "video";
			case "delete":
				videoServiceImpl.delete(id);
				List<Video> listVideoDel = videoServiceImpl.getAll();
				model.addAttribute("VideoDTO", videoContructor);
				model.addAttribute("videos", listVideoDel);
				return "redirect:/home/video";
			default:
				break;
		}
		return "redirect:/home/video";
	}

//	save and update
	@PostMapping("/video/save")
	public String saveVideo(
			Model model,
			@Valid @ModelAttribute("VideoDTO") Video videoDTO,
			BindingResult result
	) {
		List<Video> listVideo = videoServiceImpl.getAll();
//		check Empty
		if(result.hasErrors()) {
			model.addAttribute("VideoDTO", videoDTO);
			model.addAttribute("videos", listVideo);
			return "video";
		}
//		Id == null -> insert 
// 		id !-= null -> update
		if (videoDTO.getId() == null) {
			for (Video v : listVideo) {
//				check if the serial number exists
				if (videoDTO.getSeri().equals(v.getSeri())) {
					model.addAttribute("VideoDTO", videoDTO);
					model.addAttribute("videos", listVideo);
					session.setAttribute("msgVideo", "This serial number already exists!");
					return "video";
				}
			}
		}
		videoServiceImpl.add(videoDTO);
		return "redirect:/home/video";
	}

//	find video by Serial Number
	@GetMapping("/video/search-video")
	public String searchBySeri(
			@ModelAttribute("seri") Long seriNumber,
			Model model
	) {
		List<Video> videos = new ArrayList<>();
		Video videoSeri = videoServiceImpl.getBySeri(seriNumber);
		if (videoSeri != null) {
			videos.add(videoSeri);
			model.addAttribute("VideoDTO", videoSeri);
		} else {
			session.setAttribute("msgVideo", "This serial number does not exist!");
			model.addAttribute("VideoDTO", videoContructor);
		}
		
		model.addAttribute("videos", videos);
		model.addAttribute("seri", seriNumber);
		return "video";
	}
}
