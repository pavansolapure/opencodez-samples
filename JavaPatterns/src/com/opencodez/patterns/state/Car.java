package com.opencodez.patterns.state;

public class Car implements GearState {
	
	private GearState gear;
	
	@Override
	public void accelarate(int speed) {
		if(null == gear) {
			System.out.println("Car can not be accelarated as its in Neutral");
		} else {
			gear.accelarate(speed);
		}
	}
	
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
