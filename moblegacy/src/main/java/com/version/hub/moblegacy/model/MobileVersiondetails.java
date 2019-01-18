package com.version.hub.moblegacy.model;

public class MobileVersiondetails {

	private String mobileApp;
	private String mobileApi;
	private int verison;

	public String getMobileApp() {
		return mobileApp;
	}
	public void setMobileApp(String mobileApp) {
		this.mobileApp = mobileApp;
	}
	public String getMobileApi() {
		return mobileApi;
	}
	public void setMobileApi(String mobileApi) {
		this.mobileApi = mobileApi;
	}
	public int getVerison() {
		return verison;
	}
	public void setVerison(int verison) {
		this.verison = verison;
	}
	@Override
	public String toString() {
		return "MobileVersiondetails [mobileApp=" + mobileApp + ", mobileApi=" + mobileApi + ", verison=" + verison
				+ "]";
	}
	
	
}
