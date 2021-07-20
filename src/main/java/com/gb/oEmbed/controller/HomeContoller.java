package com.gb.oEmbed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContoller {
	
	@GetMapping({"/","/index"})
	public String index() {
		
		return "index";
	}
}
