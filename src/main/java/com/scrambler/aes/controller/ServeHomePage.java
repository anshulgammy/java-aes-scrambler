package com.scrambler.aes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServeHomePage {

	@RequestMapping("/start")
	public String startHtml() {
		return "redirect:/pages/home.html";
	}
}
