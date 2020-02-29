package com.basic.MyGoogleRestAssured;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class F1MyStepDef {

	Response res;
	
	@When("I hit F1 race application")
	public void I_hit_F1_race_application(){
		 res = RestAssured.get("http://ergast.com/api/f1/2017/circuits.json");
	}

	@Then("I validate the status code of F1 app")
	public void I_validate_the_status_code_of_F1_app(){
		int actualStatCode = res.getStatusCode();
		System.out.println("Actual Status Code = "+actualStatCode);
		Assert.assertTrue(200==actualStatCode);
	}
}
