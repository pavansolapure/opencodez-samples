package com.opencodez.patterns.state;

public class FirstGear implements GearState {
	
	private int gearNumber;
	
	@Override
	public void changeGear() {
		this.gearNumber = 1;
	}
	
	public int getGearNumber() {
		return gearNumber;
	}
	
	@Override
	public String toString() {
		String str = "Car is in " + gearNumber + " gear.";
		return str;
	}

}
