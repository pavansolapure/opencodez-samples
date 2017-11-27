/**
 * 
 */
package com.opencodez.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * @author pavan.solapure
 *
 */
public class CertificateUtil {

	public static CertificateDetails getCertificateDetails(String jksPath, String jksPassword) {

		CertificateDetails certDetails = null;

		try {

			boolean isAliasWithPrivateKey = false;
			KeyStore keyStore = KeyStore.getInstance("JKS");

			// Getting ClassLoader obj
			ClassLoader classLoader = CertificateUtil.class.getClassLoader();
			File file = new File(classLoader.getResource(jksPath).getFile());

			// Provide location of Java Keystore and password for access
			keyStore.load(new FileInputStream(file), jksPassword.toCharArray());

			// iterate over all aliases
			Enumeration<String> es = keyStore.aliases();
			String alias = "";
			while (es.hasMoreElements()) {
				alias = (String) es.nextElement();
				// if alias refers to a private key break at that point
				// as we want to use that certificate
				if (isAliasWithPrivateKey = keyStore.isKeyEntry(alias)) {
					break;
				}
			}

			if (isAliasWithPrivateKey) {

				KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(alias,
						new KeyStore.PasswordProtection(jksPassword.toCharArray()));

				PrivateKey myPrivateKey = pkEntry.getPrivateKey();

				// Load certificate chain
				Certificate[] chain = keyStore.getCertificateChain(alias);

				certDetails = new CertificateDetails();
				certDetails.setPrivateKey(myPrivateKey);
				certDetails.setX509Certificate((X509Certificate) chain[0]);

			}

		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnrecoverableEntryException e) {
			e.printStackTrace();
		}

		return certDetails;
	}

}
