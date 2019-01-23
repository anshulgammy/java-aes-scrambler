
package com.scrambler.aes.util;

public class AesConstants {
	public static final String SECRET_FACT_INSTANCE = "PBKDF2WithHmacSHA1";
	public static final String AES_CIPHER_PADDING = "AES/CBC/PKCS5Padding";
	public static final String ALGO_TYPE = "AES";
	public static final byte[] INTIALIZATION_VECTOR = new byte[16];
	public static final String ENCRYPT = "encrypt";
	public static final String DECRYPT = "decrypt";
	public static final String UTF_8 = "UTF-8";
}
