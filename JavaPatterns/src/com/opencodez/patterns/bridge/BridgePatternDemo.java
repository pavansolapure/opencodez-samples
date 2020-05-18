package com.opencodez.patterns.bridge;

public class BridgePatternDemo {

	public static void main(String[] args) {

		Car car1 = new Maruti(new Produce(), new Assemble());
		car1.production_house();
		Car car2 = new BMW(new Produce(), new Assemble());
		car2.production_house();

	}
}
