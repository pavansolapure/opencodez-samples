package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Example;


@Controller
public class DemoController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(Model model) {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insert(Model model) {
		model.addAttribute("exampleModel", new Example());
		return new ModelAndView("insert");
	}
	
	
	@RequestMapping(value="/insertrecord", method=RequestMethod.POST)
	public ModelAndView insertRecord(@ModelAttribute("exampleModel") Example example, Model model, HttpServletRequest request) {
		String path = getApplicationPath(request);
		RestTemplate template = new RestTemplate();
		ResponseEntity<Example> responseEntity = template.getForEntity( path + "/add/"+example.getExValue(), Example.class);
		Example ex=responseEntity.getBody();
		return new ModelAndView("redirect:/display");
	}
	
	
	@RequestMapping(value="/display", method=RequestMethod.GET)
	public ModelAndView display(Model model, HttpServletRequest request) {
		String path = getApplicationPath(request);
		RestTemplate template = new RestTemplate();

		ResponseEntity<Example[]> responseEntity = template.getForEntity(path + "/getall", Example[].class);

		Example[] examples=responseEntity.getBody();
		
		model.addAttribute("exList", examples);
		return new ModelAndView("display");
	}
	
	private String getApplicationPath(HttpServletRequest request) {
		String base = "http://localhost:8080/";
		StringBuffer path = new StringBuffer();
		path.append(base).append("/").append(request.getContextPath());
		return path.toString();
	}
}
