package com.opencodez.patterns.visitor;

public interface Visitor {
	public void visit(Person p);
	public void visit(Animal a);
	public void visit(Luggage l);
}
