package com.opencodez.patterns.visitor;

public class Animal implements Transportable {

	private double fare;
	private int numberOfAnimals;
	
	public Animal(double f, int n) {
		fare = f;
		numberOfAnimals = n;
	}	

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getNumberOfAnimals() {
		return numberOfAnimals;
	}

	public void setNumberOfAnimals(int numberOfAnimals) {
		this.numberOfAnimals = numberOfAnimals;
	}

}
