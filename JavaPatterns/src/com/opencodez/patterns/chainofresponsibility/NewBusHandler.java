package com.opencodez.patterns.chainofresponsibility;

public class NewBusHandler implements Handler {

	private Handler chain;

	@Override

	public void setNextChain(Handler nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void forwardEMail(Email mailObj) {

		if (mailObj.getSubject().equalsIgnoreCase(Handler.NEW_BUSINESS_MAIL)) // checking mail subject and then
																				// forwarding to next chain handller
		{
			System.out.println("Its a Business mail :Forwarding Mail to Business Development Department.");
		} else {
			this.chain.forwardEMail(mailObj);
		}

	}
}
