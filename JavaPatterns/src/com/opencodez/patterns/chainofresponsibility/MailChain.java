package com.opencodez.patterns.chainofresponsibility;

public class MailChain {

	private Handler chain;

	public MailChain() {
		this.chain = new SpamHandler();

		Handler recHandlerObj = new RecHandler();
		Handler othermailHandlerObj = new OtherMailHandler();
		Handler newbusinessHandlerObj = new NewBusHandler();

		chain.setNextChain(recHandlerObj);
		recHandlerObj.setNextChain(othermailHandlerObj);
		othermailHandlerObj.setNextChain(newbusinessHandlerObj);

	}

	// calling a chain with different email subject

	public static void main(String s[]) {

		MailChain mailChainObj = new MailChain();

		mailChainObj.chain.forwardEMail(new Email("SPAM_MAIL"));

		mailChainObj.chain.forwardEMail(new Email("REC_MAIL"));

		mailChainObj.chain.forwardEMail(new Email("OTHER_MAIL"));

		mailChainObj.chain.forwardEMail(new Email("NEW_BUSINESS_MAIL"));

	}
}
