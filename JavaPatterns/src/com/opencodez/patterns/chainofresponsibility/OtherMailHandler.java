package com.opencodez.patterns.chainofresponsibility;

public class OtherMailHandler implements Handler {

	private Handler chain;

	@Override

	public void setNextChain(Handler nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void forwardEMail(Email mailObj) {

		if (mailObj.getSubject().equalsIgnoreCase(Handler.OTHER_MAIL)) // checking mail subject and then forwarding to
																		// next chain handller
		{
			System.out.println("Forwarding Mail to HR Department.");
		} else {
			this.chain.forwardEMail(mailObj);
		}

	}

}
