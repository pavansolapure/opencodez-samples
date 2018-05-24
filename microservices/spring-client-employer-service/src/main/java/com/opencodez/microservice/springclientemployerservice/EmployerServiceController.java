package com.opencodez.microservice.springclientemployerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployerServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static String SERVICE = "http://EMPLOYEE-SERVICE/getEmployeeDetail/?id=";

	@RequestMapping(value = "/getEmployeeDetailForEmployer/{empID}", method = RequestMethod.GET)
	public String getEmployeeDetailForEmployer(@PathVariable int empID) {
		
		String response = restTemplate.exchange(SERVICE + empID, HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();

		System.out.println("Response Received as " + response);

		return "Employee id -  " + empID + " \n Employee Details " + response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
