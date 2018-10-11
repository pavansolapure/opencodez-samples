package com.opencodez.patterns.facade;

public class Dog implements Animal {

	@Override
	public void speak() {
		System.out.println("Dog Speaks :: Bow!! Bow!!");
	}

}
