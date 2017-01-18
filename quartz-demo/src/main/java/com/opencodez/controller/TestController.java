package com.opencodez.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencodez.util.AppUtil;
import com.opencodez.util.PropertiesUtils;

@RestController
public class TestController {
	
	@Value("${con.key2}")
	String conKey2;
	
	@RequestMapping("/getval")
    public String getVal(@RequestParam(value="key", defaultValue="World") String key) {
		Map<String, String> mapOfKeyValue = new HashMap<String, String>();
		mapOfKeyValue.put(key, PropertiesUtils.getProperty(key));
		mapOfKeyValue.put("con.key2", conKey2);
		return AppUtil.getBeanToJsonString(mapOfKeyValue);
    }
}