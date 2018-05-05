package com.opencodez.patterns.memento;

public class Originator {
	
	private String state;

	public void setState(String state) {
		System.out.println("Originator: Starting with : " + state);
		this.state = state;
	}

	public Memento saveState() {
		System.out.println("Originator: Completed :" + state);
		return new Memento(state);
	}

	public void restoreState(Memento m) {
		state = m.getState();
		System.out.println("Originator: Now player need to start with  " + state);
	}
}
