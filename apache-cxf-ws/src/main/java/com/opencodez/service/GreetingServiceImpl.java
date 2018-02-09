package com.opencodez.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.opencodez.model.Greeting;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public Greeting sayHello(String name) {
		Greeting greeting = new Greeting();
		greeting.setMessage("Hello " + name + "!!!");
		greeting.setDate(new Date());
		return greeting;
	}

	@Override
	public Greeting sayBye(String name) {
		Greeting greeting = new Greeting();
		greeting.setMessage("Bye " + name + "!!!");
		greeting.setDate(new Date());
		return greeting;
	}
}
