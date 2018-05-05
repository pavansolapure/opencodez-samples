package com.opencodez.patterns.memento;

import java.util.ArrayList;

public class Caretaker {
	
	static int cnt=1;
    private ArrayList<Memento> mementos = new ArrayList<>();

    public void addToMemento(Memento m) 
    {
        mementos.add(m);
        System.out.println("Round-" +cnt++  +" added to Memento\n");
    }

    public Memento getMemento() 
    {
    	int lastSavedState = ((mementos.size() - 1) < 0) ? 0 : (mementos.size() - 1);
    	Memento mem = mementos.get(lastSavedState);
    	
    	//remove last restored state.
    	mementos.remove(lastSavedState);
    	
        return mem;
    }
}
