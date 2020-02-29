package com.basic.getRequestBasicSD;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetRequestBasicSD {

	Response res;

	@Given("^race ciruit application is running$")
	public void race_ciruit_application_is_running() {
		System.out.println("application ready to use");
	}

	@When("^I hit get request to get response$")
	public void i_hit_get_request_to_get_response() {
		res = RestAssured.get("http://ergast.com/api/f1/2017/circuits.json");

		String actualData = res.getBody().asString();
		System.out.println("Data =     "+actualData);
	}

	@Then("^I validate circuit \"([^\"]*)\" value as \"([^\"]*)\" present$")
	public void i_validate_circuit_value_as_present(String jPath, String valueToBeValidated) {

		String attrValue =res.body().jsonPath().getString(jPath);
		Assert.assertTrue(attrValue.equals(valueToBeValidated));

	}
//	@Then("^I validate circuit total value$")
//	public void i_validate_circuit_total_value() {
//
//		String limitValue =res.body().jsonPath().getString("MRData.total");
//		Assert.assertTrue(limitValue.equals("20"));
//
//	}
	@Then("^I validate circuit id value$")
	public void i_validate_circuit_id_value() {

		String totalValue = res.body().jsonPath().getString("MRData.total");
		int totalInt = Integer.parseInt(totalValue);

		for (int i = 0; i < totalInt; i++) {
			String idValue =res.body().jsonPath().getString("MRData.CircuitTable.Circuits["+i+"].circuitId");
			if(idValue.equals("americas")){
				Assert.assertTrue(idValue.equals("americas"));
				break;
			}else{
				if(i==totalInt-1){
					Assert.assertTrue(false);
				}
			}
		}


	}

}
