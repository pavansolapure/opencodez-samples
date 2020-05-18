package com.opencodez.patterns.bridge;

public class Maruti extends Car 
{

	public Maruti (Workshop workShop1, Workshop workShop2) 
        {
		super(workShop1, workShop2);
	}

	@Override
	public void production_house() 
        {
		System.out.print("Maruti Car ");
		workShop1.work();
		workShop2.work();

	}

}

