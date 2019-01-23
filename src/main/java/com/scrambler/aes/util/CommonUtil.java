package com.scrambler.aes.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
	
	public static final ClassLoader CLASS_LOADER = ClassLoader.getSystemClassLoader();
	
	public static String[] readFromFile(final String fileName) {
		final List<String> algorithms = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		final String fileNameToRead = fileName + ".txt";
		try {
			final URL urlToFile = CLASS_LOADER.getResource(fileNameToRead);
			System.out.println(URLDecoder.decode(urlToFile.getFile()));
			final FileReader fileReader = new FileReader(URLDecoder.decode(urlToFile.getFile(), AesConstants.UTF_8));
			bufferedReader = new BufferedReader(fileReader);
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
