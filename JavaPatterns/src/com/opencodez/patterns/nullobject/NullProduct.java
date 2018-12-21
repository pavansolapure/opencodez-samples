package com.opencodez.patterns.nullobject;

public class NullProduct extends Shop {

	@Override
	public void discountedProduct() {
		System.out.println("No Discount on this item!");
	}

	@Override
	public boolean noDiscount() {
		return true;
	}

}
