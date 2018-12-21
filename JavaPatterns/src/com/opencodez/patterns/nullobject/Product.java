package com.opencodez.patterns.nullobject;

public class Product extends Shop {

	String name;

	public Product(String name) {
		this.name = name;
	}

	@Override
	public void discountedProduct() {
		System.out.println("10% Discount");
	}

	@Override
	public boolean noDiscount() {
		return false;
	}

}
