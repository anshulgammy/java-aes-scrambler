package com.scrambler.aes.model;

import org.springframework.stereotype.Component;

@Component
public class ScrambleUnscrambleModel {
	public String javaVersion;
	public String aesKeyValue;
	public String aesSaltValue;
	public String selectedAesAlgorithm;
	public String listOfStrings;
	public String selectedEncryptionBits;
	public String userAction;
	public String[] result;

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getAesKeyValue() {
		return aesKeyValue;
	}

	public void setAesKeyValue(String aesKeyValue) {
		this.aesKeyValue = aesKeyValue;
	}

	public String getAesSaltValue() {
		return aesSaltValue;
	}

	public void setAesSaltValue(String aesSaltValue) {
		this.aesSaltValue = aesSaltValue;
	}

	public String getSelectedAesAlgorithm() {
		return selectedAesAlgorithm;
	}

	public void setSelectedAesAlgorithm(String selectedAesAlgorithm) {
		this.selectedAesAlgorithm = selectedAesAlgorithm;
	}

	public String getListOfStrings() {
		return listOfStrings;
	}

	public void setListOfStrings(String listOfStrings) {
		this.listOfStrings = listOfStrings;
	}

	public String[] getResult() {
		return result;
	}

	public void setResult(String[] result) {
		this.result = result;
	}

	public String getSelectedEncryptionBits() {
		return selectedEncryptionBits;
	}

	public void setSelectedEncryptionBits(String selectedEncryptionBits) {
		this.selectedEncryptionBits = selectedEncryptionBits;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

}
