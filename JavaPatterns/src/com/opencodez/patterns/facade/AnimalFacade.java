package com.opencodez.patterns.facade;

public class AnimalFacade {
	
	private Animal dog;
	private Animal cat;
	
	public AnimalFacade() {
		dog = new Dog();
		cat = new Cat();
	}
	
	public void speakDog() {
		dog.speak();
	}
	
	public void speakCat() {
		cat.speak();
	}

}
