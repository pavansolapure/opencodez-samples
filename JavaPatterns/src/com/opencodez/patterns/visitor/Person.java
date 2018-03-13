package com.opencodez.patterns.visitor;

public class Person implements Transportable {

	private double fare;
	private int numberOfPersons;
	
	public Person(double f, int n) {
		fare = f;
		numberOfPersons = n;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}	

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
