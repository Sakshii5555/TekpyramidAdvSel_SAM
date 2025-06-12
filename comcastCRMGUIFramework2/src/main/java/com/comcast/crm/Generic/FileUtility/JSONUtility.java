package com.comcast.crm.Generic.FileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtility {

	public String getDataFromJSONFile(String key) throws Exception {
		FileReader fr = new FileReader("./AppConfigData/jsonfile.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject map = (JSONObject)obj;
		String data = (String) map.get(key);
		return data;
	}

}
