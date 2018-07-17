package com.opencodez.patterns.adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		
		Charger charger = new Charger();
		
		charger.setAdapter(new UKAdapter());
		
		charger.charge();
		
		charger.setAdapter(new GermanyAdapter());
		
		charger.charge();

	}

}
