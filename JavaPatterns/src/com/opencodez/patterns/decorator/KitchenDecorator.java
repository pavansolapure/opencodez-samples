package com.opencodez.patterns.decorator;

public class KitchenDecorator extends FlatDecorator {

	public KitchenDecorator(Flat flat) {
		super(flat);
	}

	@Override
	public String getSpecification() {
		return super.getSpecification() + " + Modular Kitchen";
	}
}
