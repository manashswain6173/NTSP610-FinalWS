package com.manash.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/home.html")
	public String showHome() {
		System.out.println("Controller Method");
		return "home";
	}

}
