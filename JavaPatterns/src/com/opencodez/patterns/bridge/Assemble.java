package com.opencodez.patterns.bridge;

public class Assemble implements Workshop
{

	@Override
	public void work() 
        {
		System.out.println(" Assembled.");
	}

}

