package com.opencodez.patterns.abstractfactory;

public class SavingsAccount implements Account {

	@Override
	public void getInterestRate() {
		System.out.println("Savings Account Interest Rate = 4.0% pa");
	}

}
