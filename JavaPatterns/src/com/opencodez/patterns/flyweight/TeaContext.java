package com.opencodez.patterns.flyweight;

class TeaContext {
	private final int tableNumber;

	public TeaContext(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getTable() {
		return this.tableNumber;
	}
}
