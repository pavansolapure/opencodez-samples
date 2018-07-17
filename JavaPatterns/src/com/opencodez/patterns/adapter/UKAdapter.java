package com.opencodez.patterns.adapter;

public class UKAdapter implements Adapter {

	@Override
	public void conntect() {
		System.out.println("Connecting to UK Plug using Adapter.");
	}

}
