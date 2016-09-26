package com.example.controller.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.GenericRepository;
import com.example.entity.Example;

@RestController
public class DemoRestController {

	/** The entity manager. */
	@Autowired
	private GenericRepository genericRepo;
	
	@Transactional
	@RequestMapping("/add/{exvalue}")
    public Example addExample(@PathVariable(value="exvalue") String exvalue) {
		Example example = new Example();
		example.setExValue(Long.parseLong(exvalue));
		genericRepo.saveExample(example);
		return example;
    }
	
	
	@RequestMapping("/getall")
    public List<Example> getExample() {
    	return genericRepo.getExamples();
    }
	
}
