package com.opencodez.patterns.decorator;

abstract class FlatDecorator implements Flat {
	
	protected Flat flatToDecorate;
	
	public FlatDecorator(Flat flat) {
		this.flatToDecorate = flat;
	}

	@Override
	public String getSpecification() {
		return this.flatToDecorate.getSpecification();
	}
	
}
