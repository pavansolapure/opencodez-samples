package com.opencodez.patterns.state;

public class Car implements GearState {
	
	private GearState gear;
	
	public void setGearState(GearState sgear) {
		gear = sgear;
	}
	
	@Override
	public void changeGear() {
		gear.changeGear();
	}
	
	public GearState getGearState() {
		return gear; 
	}	

	@Override
	public String toString() {
		return gear.toString();
	}	
	
	
	
}
