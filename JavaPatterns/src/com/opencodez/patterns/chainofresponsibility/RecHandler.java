package com.opencodez.patterns.chainofresponsibility;

public class RecHandler implements Handler {
	private Handler chain;

	@Override
	public void setNextChain(Handler nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void forwardEMail(Email mailObj) {
		if (mailObj.getSubject().equalsIgnoreCase(Handler.REC_MAIL)) // checking mail subject and then forwarding to
																		// next chain handller
		{
			System.out.println("Its a Job related mail :Forwarding Mail to Recruitment Dept");
		} else {
			this.chain.forwardEMail(mailObj);
		}

	}

}
