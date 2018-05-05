package com.opencodez.patterns.memento;

public class MementoPatternDemo {

	public static void main(String[] args) {
		
		Caretaker caretaker = new Caretaker();
		Originator originator = new Originator();
		
		originator.setState("Round-1");
		caretaker.addToMemento(originator.saveState());

		originator.setState("Round-2");
		caretaker.addToMemento(originator.saveState());
		
		originator.setState("Round-3");
		caretaker.addToMemento(originator.saveState());
		
		originator.setState("Round-4");
		System.out.println("At this stage player fails");
		originator.restoreState(caretaker.getMemento());
	}

}
