package com.opencodez.patterns.flyweight;

public class Tea implements ITea {
	private final String flavor;

	public Tea(String newFlavor) {
		this.flavor = newFlavor;
		System.out.println("Tea flavor is created! - " + flavor);
	}

	public String getFlavor() {
		return this.flavor;
	}

	public void serveTea(TeaContext context) {
		System.out.println("Serving " + flavor + " to table " + context.getTable());
	}
}
