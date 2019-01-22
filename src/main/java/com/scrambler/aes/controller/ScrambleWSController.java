package com.scrambler.aes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/scramble")
public class ScrambleWSController {
	@RequestMapping(value = "/this", method = RequestMethod.GET)
	public void testScrambleWSController() {
		System.out.println("Inside testScrambleWSController()...");
	}
}
