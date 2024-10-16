package com.crm.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

	public static String property(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./configure/vtigerLogin.properties");
			prop.load(fis);
			return prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}
}
