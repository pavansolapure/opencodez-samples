/**
 * 
 */
package com.opencodez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pavan
 *
 */
@Component
public class HttpClient implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		ResponseEntity<String> response = template.getForEntity("https://localhost:8443/ssl-server-0.0.1-SNAPSHOT/hello",
				String.class);
		System.out.println(response.getBody());
	}
}
