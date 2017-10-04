/**
 * 
 */
package com.opencodez.adldapdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pavan.solapure
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public ModelAndView Interfaces() {
		return new ModelAndView("profile");
	}
}
