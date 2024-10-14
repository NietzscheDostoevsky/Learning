package com.crm.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

	public static String property(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./Configure/dwsLogin.properties");
			prop.load(fis);
			return prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}
}
