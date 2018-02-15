package com.opencodez.patterns.template;

public class YahooAccount extends MailAccountTemplate {

	@Override
	void register() {
		System.out.println("Registered your email account with Yahoo!");
	}

}
