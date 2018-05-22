package com.opencodez.patterns.factory;

public class Factory {
	
	public static Country getCountry(String c) {
		Country country = null;
		if(c.equalsIgnoreCase("India")) {
			country = new India();
		} else if(c.equalsIgnoreCase("Japan")) {
			country = new Japan();
		}
		return country;
	}
}
