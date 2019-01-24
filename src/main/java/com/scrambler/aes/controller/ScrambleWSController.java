package com.scrambler.aes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scrambler.aes.model.JavaAlgorithms;
import com.scrambler.aes.model.ScrambleUnscrambleModel;
import com.scrambler.aes.service.AesService;

@Controller
@RequestMapping("/scramble")
public class ScrambleWSController {
	
	@Autowired
	private AesService aesService;
	
	@RequestMapping(value = "/getalgo", method = RequestMethod.POST)
	@ResponseBody
	public JavaAlgorithms getAlgorithms(@RequestBody JavaAlgorithms javaAlgos) {
		System.out.println("Inside getAlgorithms...");
		final JavaAlgorithms algoResponse = aesService.getAlgorithms(javaAlgos.getJavaVersion());
		return algoResponse;
	}
	
	@RequestMapping(value = "/getscrambles", method = RequestMethod.POST)
	@ResponseBody
	public ScrambleUnscrambleModel getScrambles(@RequestBody ScrambleUnscrambleModel scrambleUnscrambleModel) {
		System.out.println("Inside getScrambles...");
		final ScrambleUnscrambleModel resposne = aesService.getScrambles(scrambleUnscrambleModel);
		return resposne;
	}
}
