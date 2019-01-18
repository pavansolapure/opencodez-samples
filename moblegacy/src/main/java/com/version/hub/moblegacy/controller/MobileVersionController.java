package com.version.hub.moblegacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.version.hub.moblegacy.model.MobileVersiondetails;
import com.version.hub.moblegacy.service.MobileVersionService;

@RestController
public class MobileVersionController {
	
	@Autowired
	private MobileVersionService mobileVersionService; 
	
	@RequestMapping(value = "/mobiledetail", method = RequestMethod.GET)
	public List<MobileVersiondetails> getMobileDeatil() {
		return mobileVersionService.populateVersionDetail();
	}
	
	//http://localhost:8080/latestApp will return the desired output i.e. chatApp 
	@RequestMapping(value = "/latestApp", method = RequestMethod.GET)
	public List<MobileVersiondetails> getLatestApp() {
		return mobileVersionService.getAppNameWithLatestAPI();
	}

}
