package com.basic.MyGoogleRestAssured;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeleniumDevStepDef {


	WebDriver driver;

	@Given("Open Browser")
	public void Open_Browser(){
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@When("I hit Selenium website")
	public void I_hit_Selenium_website(){
		driver.get("https://selenium.dev/");
	}

	@When("I click Projects tab")
	public void I_click_Projects_tab(){
		driver.findElement(By.xpath("//nav/a[contains(text(),'Projects')]")).click();
	}

	@Then("I validate Project tab")
	public void I_validate_Project_tab(){
		
		Assert.assertTrue(driver.getCurrentUrl().contains("projects"));
	}

}
