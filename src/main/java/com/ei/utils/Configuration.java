package com.ei.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private static Properties props;
	private static Configuration instance = new Configuration();

	private Configuration() {
		try {
			props = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\ei\\config\\config.properties");

			props.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Configuration getConfig() {
		return instance;
	}

	public static String get(String key) {
		return props.getProperty(key);
	}
}
