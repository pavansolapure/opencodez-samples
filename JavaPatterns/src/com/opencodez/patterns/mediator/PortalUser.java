package com.opencodez.patterns.mediator;

public class PortalUser {
	
	private String name;
	
	public PortalUser(String name) {
		this.name = name;
	}

	public void sendMessage(String message) {
		OpenPortal.showMessage(message, this);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
