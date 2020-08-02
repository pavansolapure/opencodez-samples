package com.opencodez.patterns.chainofresponsibility;

public class Email {

	private String mailsubject;

	public Email(String mailsubject) {
		this.mailsubject = mailsubject;
	}

	public String getSubject() {
		return mailsubject;
	}

	public void setSubject(String mailsubject) {
		this.mailsubject = mailsubject;
	}

}
