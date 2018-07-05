package com.opencodez.actuators;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myfeatures")
public class CustomFeatureEndPoint {
	
	private Map<String, Object> features = new ConcurrentHashMap<>();
	 
    @ReadOperation
    public Map<String, Object> features() {
    	features.put("customFeature", "Hello World!");
        return features;
    }
}
