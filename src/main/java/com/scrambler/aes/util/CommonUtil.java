package com.scrambler.aes.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
	
	public static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();
	
	public static String[] readFromFile(final String fileName) {
		final List<String> algorithms = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		final String fileNameToRead = fileName + ".txt";
		try {
			final InputStream inputStream = CLASS_LOADER.getResourceAsStream(fileNameToRead);
		    final InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		    bufferedReader = new BufferedReader(streamReader);
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				algorithms.add(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (String[]) algorithms.toArray();
	}
}
