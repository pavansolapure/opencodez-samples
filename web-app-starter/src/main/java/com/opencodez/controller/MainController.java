/**
 * 
 */
package com.opencodez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.opencodez.util.ApplicationLogger;


@Controller
@RequestMapping("/")
public class MainController {
	
	private static final ApplicationLogger logger = ApplicationLogger.getInstance();
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		logger.entry();
		logger.exit();
		return new ModelAndView("index");
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public ModelAndView contact() {
		logger.entry();
		logger.exit();
		return new ModelAndView("contact");
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		logger.entry();
		logger.exit();
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/admin/", method = RequestMethod.GET)
	public ModelAndView admin() {
		logger.entry();
		logger.exit();
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/admin/newpage", method = RequestMethod.GET)
	public ModelAndView newpage() {
		logger.entry();
		logger.exit();
		return new ModelAndView("newpage");
	}
	
	
}
