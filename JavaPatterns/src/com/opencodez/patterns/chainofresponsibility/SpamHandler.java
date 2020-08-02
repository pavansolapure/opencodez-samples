package com.opencodez.patterns.chainofresponsibility;

public class SpamHandler implements Handler {

	private Handler chain;

	@Override
	public void setNextChain(Handler nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void forwardEMail(Email mailObj) {

		if (mailObj.getSubject().equalsIgnoreCase(Handler.SPAM_MAIL)) // checking mail subject and then forwarding to
																		// next chain handller
		{
			System.out.println("its a SPAM mail : Mail Deleted.");
		} else {
			this.chain.forwardEMail(mailObj);
		}
	}

}
