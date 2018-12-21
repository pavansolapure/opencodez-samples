package com.opencodez.patterns.nullobject;

public class NullPatternDemo {
	
	public static void main(String[] args) {
		
		Shop s1 = ProductFactory.getProduct("Tshirt");
		Shop s2 = ProductFactory.getProduct("Trouser");
		Shop s3 = ProductFactory.getProduct("Officebag");
		Shop s4 = ProductFactory.getProduct("Shoes");
		Shop s5 = ProductFactory.getProduct("Belt");

		s1.discountedProduct();
		s2.discountedProduct();
		s3.discountedProduct();
		s4.discountedProduct();
		s5.discountedProduct();

	}
}
