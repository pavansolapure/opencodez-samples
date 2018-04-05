package com.opencodez.controllers;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetectController {

	@RequestMapping("/detect")
	public String detect(Device device, Model model) {
		
		String deviceType = null;
		if (device.isMobile()) {
			deviceType = "Mobile";
		} else if (device.isTablet()) {
			deviceType = "Tablet";
		} else {
			deviceType = "Desktop";
		}
		
		System.out.println("Hello User, you are viewing this applicaiton on " + deviceType);
		
		model.addAttribute("deviceType", deviceType);
		return "detect";
	}
}
