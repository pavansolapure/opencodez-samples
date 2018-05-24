package com.opencodez.microservice.springdiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiscoveryServerApplication.class, args);
	}
}
