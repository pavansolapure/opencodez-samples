package com.opencodez.patterns.decorator;

public class FurnitureDecorator extends FlatDecorator {

	public FurnitureDecorator(Flat flat) {
		super(flat);
	}

	@Override
	public String getSpecification() {
		return super.getSpecification() + " + Furnishing";
	}
}
