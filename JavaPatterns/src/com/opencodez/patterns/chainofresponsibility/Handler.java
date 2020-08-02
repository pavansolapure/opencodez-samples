package com.opencodez.patterns.chainofresponsibility;

public interface Handler {
	String SPAM_MAIL = "SPAM_MAIL";
	String REC_MAIL = "REC_MAIL";
	String OTHER_MAIL = "OTHER_MAIL";
	String NEW_BUSINESS_MAIL = "NEW_BUSINESS_MAIL";

	void setNextChain(Handler nextChain);

	void forwardEMail(Email mailObj);

}
