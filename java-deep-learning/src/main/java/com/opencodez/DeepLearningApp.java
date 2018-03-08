package com.opencodez;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeepLearningApp implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DeepLearningApp.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		IrisClassifier classifier = new IrisClassifier();
		classifier.classify("iris.csv","iris-test.csv");
	}
}
