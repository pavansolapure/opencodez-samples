package com.opencodez.patterns.adapter;

public class Charger {
	
	private String country;
	
	private Adapter adapter;
	
	public void charge() {
		adapter.conntect();
		System.out.println("Charging...");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}
	
}
