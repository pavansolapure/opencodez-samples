package com.opencodez.patterns.state;

public class SecondGear implements GearState {
	
	private int gearNumber;
	
	@Override
	public void changeGear() {
		this.gearNumber = 2;
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
		if(speed > 40) {
			System.out.println("Can not be accelarated to " + speed + " in gear 2");
		} else {
			System.out.println("Car is running at " + speed + " kmph in gear 2");
		}		
	}	
}
