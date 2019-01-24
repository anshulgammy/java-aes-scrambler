package com.scrambler.aes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scrambler.aes.model.ScrambleUnscrambleModel;
import com.scrambler.aes.service.AesService;

@Controller
@RequestMapping("/unscramble")
public class UnscrambleWSController {
	
	@Autowired
	private AesService aesService;
	
	@RequestMapping(value = "/getunscrambles", method = RequestMethod.POST)
	@ResponseBody
	public ScrambleUnscrambleModel getUnscrambles(@RequestBody ScrambleUnscrambleModel scrambleUnscrambleModel) {
		System.out.println("Inside getUnscrambles...");
		final ScrambleUnscrambleModel resposne = aesService.getScrambles(scrambleUnscrambleModel);
		return resposne;
	}
}
