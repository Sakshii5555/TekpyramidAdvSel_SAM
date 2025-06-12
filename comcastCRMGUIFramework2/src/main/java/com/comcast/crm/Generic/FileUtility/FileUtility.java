package com.comcast.crm.Generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./AppConfigData/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key); 
		return data;

	}

}
