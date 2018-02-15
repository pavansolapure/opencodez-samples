package com.opencodez.patterns.template;

public class TemplatePatternDemo {

	public static void main(String[] args) {

		MailAccountTemplate gmail = new GmailAccount();
		gmail.createAccount();
		
		MailAccountTemplate ymail = new YahooAccount();
		ymail.createAccount();

	}

}
