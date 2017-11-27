/**
 * 
 */
package com.opencodez.util;

import java.io.File;
import java.io.FileInputStream;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Address;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.smime.SMIMECapabilitiesAttribute;
import org.bouncycastle.asn1.smime.SMIMECapability;
import org.bouncycastle.asn1.smime.SMIMECapabilityVector;
import org.bouncycastle.asn1.smime.SMIMEEncryptionKeyPreferenceAttribute;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoGeneratorBuilder;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.mail.smime.SMIMEEnvelopedGenerator;
import org.bouncycastle.mail.smime.SMIMESignedGenerator;

/**
 * @author pavan.solapure
 *
 */
public class MailEncryptionUtil {
	
	private static final String SIGNING_JKS = "opencodez.jks";
	
	//This can be externalize and encrypted using Jasypt or any other methods
	private static final String SECRET_KEY = "op3n.cod3z";

	public static MimeMessage encryptMessage(MimeMessage message) throws Exception  {
		
		Security.addProvider(new BouncyCastleProvider());
		
        // create the generator for creating an smime/encrypted message
        SMIMEEnvelopedGenerator  gen = new SMIMEEnvelopedGenerator();
        
        X509Certificate recipientCert = getRecipientPublicCertificate(message);
        
        gen.addRecipientInfoGenerator(new JceKeyTransRecipientInfoGenerator(recipientCert).setProvider("BC"));
		
		MimeBodyPart msg = new MimeBodyPart();
		msg.setContent(message.getContent(), message.getContentType());
		
		MimeBodyPart mp = gen.generate(msg, new JceCMSContentEncryptorBuilder(CMSAlgorithm.RC2_CBC).setProvider("BC").build());
		message.setContent(mp.getContent(), mp.getContentType());
		message.saveChanges();
		
		return message;
	}
	
	
	public static MimeMessage signMessage(MimeMessage message) throws Exception {
		
		Security.addProvider(new BouncyCastleProvider());

		CertificateDetails certDetails = CertificateUtil.getCertificateDetails(SIGNING_JKS,	SECRET_KEY);
		
		// Create the SMIMESignedGenerator
		SMIMECapabilityVector capabilities = new SMIMECapabilityVector();
		capabilities.addCapability(SMIMECapability.dES_EDE3_CBC);
		capabilities.addCapability(SMIMECapability.rC2_CBC, 128);
		capabilities.addCapability(SMIMECapability.dES_CBC);
		capabilities.addCapability(SMIMECapability.aES256_CBC);
		
		ASN1EncodableVector attributes = new ASN1EncodableVector();
		attributes.add(new SMIMECapabilitiesAttribute(capabilities));
		
        IssuerAndSerialNumber issAndSer = new IssuerAndSerialNumber(new X500Name(certDetails.getX509Certificate().getIssuerDN().getName()),
				certDetails.getX509Certificate().getSerialNumber());
		attributes.add(new SMIMEEncryptionKeyPreferenceAttribute(issAndSer));
		
		SMIMESignedGenerator signer = new SMIMESignedGenerator();
		
		signer.addSignerInfoGenerator(new JcaSimpleSignerInfoGeneratorBuilder()
				.setProvider("BC")
				.setSignedAttributeGenerator(new AttributeTable(attributes))
				.build("SHA1withRSA", certDetails.getPrivateKey(), 
						certDetails.getX509Certificate()));
		
		// Add the list of certs to the generator
		List<X509Certificate> certList = new ArrayList<X509Certificate>();
		certList.add(certDetails.getX509Certificate());
		
		JcaCertStore bcerts = new JcaCertStore(certList);
		signer.addCertificates(bcerts);
		
		// Sign the message
		MimeMultipart mm = signer.generate(message);

		// Set the content of the signed message
		message.setContent(mm, mm.getContentType());
		message.saveChanges();
		
		return message;
	}
	
	private static X509Certificate getRecipientPublicCertificate(MimeMessage message) throws Exception {

		//for future - add routine to fetch public certificate for email
		//for now - just print the email and use fixed certificate 
		for(Address addrs: message.getAllRecipients()) {
			System.out.println(addrs.toString());
		}
		
		CertificateFactory fact = CertificateFactory.getInstance("X.509");
		ClassLoader classLoader = MailEncryptionUtil.class.getClassLoader();
		File file = new File(classLoader.getResource("solapure@opencodez.com.cer").getFile());
        FileInputStream is = new FileInputStream (file);
        X509Certificate recipientCert = (X509Certificate) fact.generateCertificate(is);
        return recipientCert;
	}
		

}
