package com.uiAutomation.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	private  Properties properties;
	
	/**
	 * This method  is used to load  the properties from config.properties files
	 * @return it returns properties
	 */
	public Properties init_properties() {
		properties = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
}
