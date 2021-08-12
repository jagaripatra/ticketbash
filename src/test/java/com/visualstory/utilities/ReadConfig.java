package com.visualstory.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {
		String configPath = "configuration\\config.properties";
		try {
			FileInputStream fis = new FileInputStream(configPath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getApplicationURL() {
		return prop.getProperty("baseURL");
	}
}
