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

	@Override
	public void accelarate(int speed) {
		if(speed > 20) {
			System.out.println("Can not be accelarated to " + speed + " kmph in gear 1");
		} else {
			System.out.println("Car is running at " + speed + " kmph in gear 1");
		}		
	}

}
