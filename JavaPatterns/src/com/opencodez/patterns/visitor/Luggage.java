package com.opencodez.patterns.visitor;

public class Luggage implements Transportable {

	private double fare;
	private double weight;
	
	public Luggage(double f, double w) {
		fare = f;
		weight = w;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
