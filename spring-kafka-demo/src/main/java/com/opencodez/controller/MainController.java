/**
 * 
 */
package com.opencodez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class MainController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ModelAndView messages() {
		return new ModelAndView("messages");
	}
	
	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	@ResponseBody
	public String ajaxtest() {
		return "Pavan Solapure";
	}
	
}
