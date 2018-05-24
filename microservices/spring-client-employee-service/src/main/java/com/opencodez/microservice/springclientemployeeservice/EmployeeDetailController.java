package com.opencodez.microservice.springclientemployeeservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDetailController {
	
	@RequestMapping(value = "/getEmployeeDetail/" , method = RequestMethod.GET)
	public Employee getEmployeeDetail(@RequestParam("id") int id) {
		System.out.println("Getting employee detail...");
		List<Employee> list = new ArrayList<Employee>();
		
		//sample data
		list.add(new Employee(1, "Alex"));
		list.add(new Employee(2, "Robin"));
		
		return list.get(id-1);
	}

}
