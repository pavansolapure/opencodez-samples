package com.opencodez;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchDemoApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
