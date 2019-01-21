package com.techbrunch.innovation.aes_scrambler.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import com.techbrunch.innovation.aes_scrambler.util.AesConstants;

public class Encrypt {

	public static String encrypt(final String stringToEncrypt,
			final String secretKey, final String salt, final String encryptionBits) {
		try {
			final byte[] iv = AesConstants.INTIALIZATION_VECTOR;
			final byte[] saltBytes = salt.getBytes(StandardCharsets.UTF_8);
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory factory = SecretKeyFactory
					.getInstance(AesConstants.SECRET_FACT_INSTANCE);
			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), saltBytes,
					65536, Integer.parseInt(encryptionBits));
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec generatedKey = new SecretKeySpec(tmp.getEncoded(),
					AesConstants.ALGO_TYPE);

			Cipher cipher = Cipher.getInstance(AesConstants.AES_CIPHER_PADDING);
			cipher.init(Cipher.ENCRYPT_MODE, generatedKey, ivspec);
			return Base64.getEncoder().encodeToString(
					cipher.doFinal(stringToEncrypt
							.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
			e.printStackTrace();
		}
		return null;
	}

}
