package com.opencodez.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.opencodez.model.Greeting;

@WebService(serviceName = "InfoService")
public interface InfoService {
	@WebMethod()
	@WebResult(name = "Greeting")
	public Greeting sayHowAreYou(@WebParam(name = "GreetingsRequest") String name);	
}
