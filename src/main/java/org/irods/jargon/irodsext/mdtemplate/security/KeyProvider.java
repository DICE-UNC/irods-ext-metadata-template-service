package org.irods.jargon.irodsext.mdtemplate.security;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyProvider {


	static RSAPrivateKey getPrivatekey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
		
		File privKeyFile = new File("C:\\Users\\hetalben\\opt\\etc\\key\\private.der");

		// read private key DER file
		DataInputStream dis = new DataInputStream(new FileInputStream(privKeyFile));
		byte[] privKeyBytes = new byte[(int)privKeyFile.length()];
		dis.read(privKeyBytes);
		dis.close();

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		
		// decode private key
		PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privKeyBytes);
		RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(privSpec);

		return privKey;
	}

	static RSAPublicKey getPublickey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {

		File pubKeyFile = new File("C:\\Users\\hetalben\\opt\\etc\\key\\public.der");

		// read public key DER file
		DataInputStream dis = new DataInputStream(new FileInputStream(pubKeyFile));
		byte[] pubKeyBytes = new byte[(int)pubKeyFile.length()];
		dis.readFully(pubKeyBytes);
		dis.close();


		KeyFactory keyFactory = KeyFactory.getInstance("RSA");

		// decode public key
		X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyBytes);
		RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(pubSpec);

		return pubKey;
	}

}
