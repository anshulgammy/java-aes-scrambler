package com.scrambler.aes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scrambler.aes.util.CommonUtil;

@Controller
public class ServeHomePage {

	@RequestMapping("/start")
	public String startHtml() {
		System.out.println("Inside startHtml()...");
		System.out.println(CommonUtil.readFromFile("java67"));
		return "redirect:/pages/home.html";
	}
}
