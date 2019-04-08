package com.opencodez.patterns.abstractfactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		AbstractFactory lf = FactoryProvider.getFactory("Loan");

		Account loan1 = lf.getAccount("Home");
		loan1.getInterestRate();

		Account loan2 = lf.getAccount("Education");
		loan2.getInterestRate();

		AbstractFactory af = FactoryProvider.getFactory("Account");

		Account account1 = af.getAccount("Savings");
		account1.getInterestRate();

		Account account2 = af.getAccount("Current");
		account2.getInterestRate();

	}

}
