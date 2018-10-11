package com.opencodez.patterns.facade;

public class FacadeDemo {

	public static void main(String[] args) {
		
		AnimalFacade af = new AnimalFacade();
		af.speakDog();
		af.speakCat();
		
	}
}
