package com.opencodez.patterns.bridge;

public class BMW extends Car {

	public BMW(Workshop workShop1, Workshop workShop2) {
		super(workShop1, workShop2);
	}

	@Override
	public void production_house() {
		System.out.print("BMW Car ");
		workShop1.work();
		workShop2.work();
	}

}
