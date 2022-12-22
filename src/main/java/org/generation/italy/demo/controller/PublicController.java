package org.generation.italy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PublicController {

	
	@GetMapping 
	public String getHomePage(Model model) {
		model.addAttribute("routeName", "home");
		return "home"; 
	}
}
