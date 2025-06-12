package com.testng.annotation.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {
	@Test(dataProvider="getData")
	public void sample(String firstname, String lastname, long mobile_num) {
		System.out.println("FirstName: "+ firstname + "LastName: "+ lastname + "MobileNumber: "+mobile_num );
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[3][3];
		obj[0][0] = "Sakshi";
		obj[0][1] = "Tonape";
		obj[0][2] = 8411900092l;
		
		obj[1][0] = "Kshitij";
		obj[1][1] = "Tonape";
		obj[1][2] = 8698300096l;
		
		obj[2][0] = "Siddhi";
		obj[2][1] = "Tonape";
		obj[2][2] = 9420900096l;
		
		return obj;
	}
}
