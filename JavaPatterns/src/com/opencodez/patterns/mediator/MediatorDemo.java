package com.opencodez.patterns.mediator;

public class MediatorDemo {

	public static void main(String[] args) {
		PortalUser jack = new PortalUser("Jack");
		PortalUser tony = new PortalUser("Tony");
		
		jack.sendMessage("Hi Tony.");
		tony.sendMessage("Hello Jack, how are you?");
	}

}
