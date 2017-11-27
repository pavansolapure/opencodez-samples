/**
 * 
 */
package com.opencodez.util;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/**
 * @author pavan.solapure
 *
 */
public class CertificateDetails {
	
	private PrivateKey privateKey;
	
	private X509Certificate x509Certificate;

	/**
	 * @return the privateKey
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	/**
	 * @param privateKey the privateKey to set
	 */
	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * @return the x509Certificate
	 */
	public X509Certificate getX509Certificate() {
		return x509Certificate;
	}

	/**
	 * @param x509Certificate the x509Certificate to set
	 */
	public void setX509Certificate(X509Certificate x509Certificate) {
		this.x509Certificate = x509Certificate;
	} 

}
