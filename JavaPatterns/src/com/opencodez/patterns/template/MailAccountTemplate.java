package com.opencodez.patterns.template;

public abstract class MailAccountTemplate {
	
	private void acceptInputs() {
		System.out.println("Accepting email id to create account");
	}
	
	abstract void register();
	
	public final void createAccount() {
		//accept the desired email address
		acceptInputs();
		
		//register with respective Email Provider
		register();
		
		//Display confirmation for account creation.
		displayConfirmation();
	}
	
	private void displayConfirmation() {
		System.out.println("Account created!!");
	}
}
