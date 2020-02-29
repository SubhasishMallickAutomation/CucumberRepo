package com.basic.MyGoogleRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicsOfRestAssured {
	
	@Test
	public void TestGoogle() {
		
		Response res = RestAssured.get("https://google.com");
		int actualStatCode = res.getStatusCode();
		System.out.println("Actual Status Code = "+actualStatCode);
		Assert.assertTrue(200==actualStatCode);
	}
	
	@Test
	public void F1() {
		
		Response res = RestAssured.get("http://ergast.com/api/f1/2017/circuits.json");
		int actualStatCode = res.getStatusCode();
		System.out.println("Actual Status Code = "+actualStatCode);
		Assert.assertTrue(200==actualStatCode);
		
		String actualData = res.getBody().asString();
	System.out.println("Data =     "+actualData);
	}
	

}
