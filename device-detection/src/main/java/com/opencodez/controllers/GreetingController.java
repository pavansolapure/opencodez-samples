package com.opencodez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	public String greeting() {
		return "greeting";
	}
}
