package com.scrambler.aes.service;

import org.springframework.stereotype.Service;

import com.scrambler.aes.decrypt.Decrypt;
import com.scrambler.aes.encrypt.Encrypt;
import com.scrambler.aes.model.JavaAlgorithms;
import com.scrambler.aes.model.ScrambleUnscrambleModel;
import com.scrambler.aes.util.AesConstants;
import com.scrambler.aes.util.CommonUtil;

@Service
public class AesService {
	public JavaAlgorithms getAlgorithms(final String javaVersion) {
		final JavaAlgorithms response = new JavaAlgorithms();
		response.setJavaVersion(javaVersion);
		response.setJavaAlgorithms(CommonUtil.readFromFile(javaVersion));
		return response;
	}

	public ScrambleUnscrambleModel getScrambles(final ScrambleUnscrambleModel scrambleUnscrambleModel) {
		final ScrambleUnscrambleModel response = new ScrambleUnscrambleModel();
		response.setJavaVersion(scrambleUnscrambleModel.getJavaVersion());
		response.setAesKeyValue(scrambleUnscrambleModel.getAesKeyValue());
		response.setAesSaltValue(scrambleUnscrambleModel.getAesSaltValue());
		response.setListOfStrings(scrambleUnscrambleModel.getListOfStrings());
		response.setSelectedAesAlgorithm(scrambleUnscrambleModel.getSelectedAesAlgorithm());
		final String[] arrayOfStrings = scrambleUnscrambleModel.getListOfStrings().split(",");
		String[] result = null;
		if (AesConstants.ENCRYPT.equals(scrambleUnscrambleModel.getUserAction())) {
			result = resultFromEncrypt(arrayOfStrings, scrambleUnscrambleModel.getAesKeyValue(),
					scrambleUnscrambleModel.getAesSaltValue(), scrambleUnscrambleModel.getSelectedEncryptionBits(),
					scrambleUnscrambleModel.getSelectedAesAlgorithm());
		} else if (AesConstants.DECRYPT.equals(scrambleUnscrambleModel.getUserAction())) {
			result = resultFromDecrypt(arrayOfStrings, scrambleUnscrambleModel.getAesKeyValue(),
					scrambleUnscrambleModel.getAesSaltValue(), scrambleUnscrambleModel.getSelectedEncryptionBits(),
					scrambleUnscrambleModel.getSelectedAesAlgorithm());
		}
		response.setResult(result);
		return response;
	}

	private String[] resultFromEncrypt(final String[] arrayOfStrings, final String secretKey, final String salt,
			final String encryptionBits, final String secretFactoryInstance) {
		final String[] result = new String[arrayOfStrings.length];
		for (int i = 0; i < arrayOfStrings.length; i++) {
			result[i] = Encrypt.encrypt(arrayOfStrings[i], secretKey, salt, encryptionBits, secretFactoryInstance);
		}
		return result;
	}

	private String[] resultFromDecrypt(final String[] arrayOfStrings, final String secretKey, final String salt,
			final String encryptionBits, final String secretFactoryInstance) {
		final String[] result = new String[arrayOfStrings.length];
		for (int i = 0; i < arrayOfStrings.length; i++) {
			result[i] = Decrypt.decrypt(arrayOfStrings[i], secretKey, salt, encryptionBits, secretFactoryInstance);
		}
		return result;
	}
}
