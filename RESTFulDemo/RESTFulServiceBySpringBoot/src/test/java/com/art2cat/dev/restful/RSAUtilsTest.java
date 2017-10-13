package com.art2cat.dev.restful;

import com.art2cat.dev.restful.utils.RSAUtils;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAUtilsTest {

	@Test
	public void testDecrypt() {
		//随机生成publicKey和privateKey
		KeyPair keyPair = RSAUtils.generateRSAKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		byte[] encrypt = RSAUtils.encryptData(publicKey, "Fuck you".getBytes());
		Assert.assertNotNull(encrypt);
		System.out.println(new String(encrypt));
		byte[] decrypt = RSAUtils.decryptData(privateKey, encrypt);
		Assert.assertNotNull(decrypt);
		System.out.println(new String(decrypt));
	}
}
