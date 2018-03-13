package com.opencodez.patterns.visitor;

public class Taxi implements Visitor {
	
	private double totalFare;

	@Override
	public void visit(Person p) {
		totalFare = totalFare + (p.getFare() * p.getNumberOfPersons());
	}

	@Override
	public void visit(Animal a) {
		totalFare = totalFare + (a.getFare() * a.getNumberOfAnimals());	
	}

	@Override
	public void visit(Luggage l) {
		totalFare = totalFare + (l.getFare() * l.getWeight());
	}

	public double getTotalFare() {
		return totalFare;
	}
	
}
