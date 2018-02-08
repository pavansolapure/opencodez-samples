package com.opencodez.patterns.state;

public class StatePatternDemo {

	public static void main(String[] args) {
		Car car = new Car();
		car.setGearState(new FirstGear());
		car.changeGear();
		
		System.out.println(car);

		car.setGearState(new SecondGear());
		car.changeGear();
		
		System.out.println(car);
	
	}

}
