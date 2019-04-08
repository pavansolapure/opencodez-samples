package com.opencodez.patterns.abstractfactory;

public class LoanFactory extends AbstractFactory {

	@Override
	Account getAccount(String type) {

		Account account = null;

		if ("Home".equalsIgnoreCase(type)) {
			account = new HomeLoan();
		} else if ("Education".equalsIgnoreCase(type)) {
			account = new EducationLoan();
		}

		return account;
	}

}
