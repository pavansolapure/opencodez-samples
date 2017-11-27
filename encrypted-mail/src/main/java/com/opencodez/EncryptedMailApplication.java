package com.opencodez;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencodez.util.email.Email;
import com.opencodez.util.email.EmailService;
import com.opencodez.util.email.EmailTemplate;

@SpringBootApplication
public class EncryptedMailApplication implements ApplicationRunner {
	
	@Autowired
	EmailService emailService;
	
	public static void main(String[] args) {
		SpringApplication.run(EncryptedMailApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("EncryptedMail Application Started !!");
		sendMails();
	}
	
	private void sendMails() {

		String from = "pavan@opencodez.com";
		String to = "solapure@opencodez.com";
		String subject = "Java Mail with Spring Boot - Plain Text";

		EmailTemplate template = new EmailTemplate("hello-world-plain.txt");

		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", "Pavan");
		replacements.put("today", String.valueOf(new Date()));

		String message = template.getTemplate(replacements);

		Email email = new Email(from, to, subject, message);

		
		try {
			//Mail Signing
			emailService.signAndSend(email);
			
			//Main Encryption
			emailService.encryptAndSend(email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
