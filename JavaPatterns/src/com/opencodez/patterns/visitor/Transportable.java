package com.opencodez.patterns.visitor;

public interface Transportable {
	public void accept(Visitor v);
}
