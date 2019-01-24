package com.scrambler.aes.model;

import org.springframework.stereotype.Component;

@Component
public class JavaAlgorithms {
	public String javaVersion;
	public String[] javaAlgorithms;

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String[] getJavaAlgorithms() {
		return javaAlgorithms;
	}

	public void setJavaAlgorithms(String[] javaAlgorithms) {
		this.javaAlgorithms = javaAlgorithms;
	}

}
