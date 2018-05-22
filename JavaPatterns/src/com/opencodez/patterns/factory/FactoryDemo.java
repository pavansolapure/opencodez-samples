package com.opencodez.patterns.factory;

public class FactoryDemo {

	public static void main(String[] args) {
		String input = "India";
		Country ci = Factory.getCountry(input);
		System.out.println(ci);
		
		input = "Japan";
		Country cj = Factory.getCountry(input);
		System.out.println(cj);
	}
}
