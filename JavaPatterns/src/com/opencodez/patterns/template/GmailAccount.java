package com.opencodez.patterns.template;

public class GmailAccount extends MailAccountTemplate {

	@Override
	void register() {
		System.out.println("Registered your email account with Gmail");
	}

}
