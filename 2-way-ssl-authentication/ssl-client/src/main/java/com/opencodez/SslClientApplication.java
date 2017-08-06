package com.opencodez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SslClientApplication {
	
	static
	{
		System.setProperty("javax.net.debug", "all");
		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
		System.setProperty("https.protocols", "TLSv1.2");
		System.setProperty("javax.net.ssl.trustStore", "c://core-jks//MyClient.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		System.setProperty("javax.net.ssl.keyStore",  "c://core-jks//MyClient.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		
		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				new javax.net.ssl.HostnameVerifier() {

					public boolean verify(String hostname,
							javax.net.ssl.SSLSession sslSession) {
						if (hostname.equals("localhost")) {
							return true;
						}
						return false;
					}
				});
	}

	@Bean
	public RestTemplate template() throws Exception{
		RestTemplate template = new RestTemplate();
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(SslClientApplication.class, args);
	}
}
