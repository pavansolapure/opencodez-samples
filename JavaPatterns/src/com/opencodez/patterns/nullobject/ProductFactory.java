package com.opencodez.patterns.nullobject;

public class ProductFactory {
	
	public static final String[] names = { "Shoes", "TShirt", "Jeans", "Bag", "Sack" };

	public static Shop getProduct(String name) {

		for (int i = 0; i < names.length; i++) {
			if (names[i].equalsIgnoreCase(name)) {
				return new Product(name);
			}
		}
		return new NullProduct();
	}

}
