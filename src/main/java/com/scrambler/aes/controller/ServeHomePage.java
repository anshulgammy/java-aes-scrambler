package com.scrambler.aes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServeHomePage {

	@RequestMapping("/start")
	public String startHtml() {
		System.out.println("Inside startHtml()...");
		return "home";
	}
}
