package com.opencodez.patterns.decorator;

public class GardenDecorator extends FlatDecorator {

	public GardenDecorator(Flat flat) {
		super(flat);
	}

	@Override
	public String getSpecification() {
		return super.getSpecification() + " + Garden";
	}
}
