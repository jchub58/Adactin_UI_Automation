package com.adactin.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SearchHotelPage;
import com.adactin.utils.ConfigReader;

public class SearchHotelPageTests extends Basetest {
	SearchHotelPage searchHotelPage;
	LoginPage loginpage;
			
	@BeforeMethod
	public void pageContext() {
		searchHotelPage=new SearchHotelPage(driver);
		loginpage =new LoginPage(driver);
	}
	
	@Test
	public void VerifyCheckinFieldMsg() throws IOException {
		Properties prop = ConfigReader.getPropertyObject();
	    String USERNAME = prop.getProperty("USERNAME");
	    String PASSWORD = prop.getProperty("PASSWORD");
	    loginpage.getUsernameField().sendKeys(USERNAME);
	    loginpage.getPasswordField().sendKeys(PASSWORD);
	    loginpage.getLoginButton().click();
	    
		searchHotelPage.getCheckinDatefield().clear();
		searchHotelPage.getCheckinDatefield().sendKeys("28/10/2025");
		searchHotelPage.getCheckoutDatefield().clear();
		searchHotelPage.getCheckoutDatefield().sendKeys("25/10/2025");	
		searchHotelPage.getSearchButton().click();
		
		boolean checkinValidation=false;
		if (searchHotelPage.getCheckinError().contains("Check-In Date shall be before than Check-Out Date")) {
			checkinValidation=true;
		}
		Assert.assertTrue(checkinValidation);
	}
	@Test
	public void verifyLocationInResults() throws IOException {
		Properties prop = ConfigReader.getPropertyObject();
	    String USERNAME = prop.getProperty("USERNAME");
	    String PASSWORD = prop.getProperty("PASSWORD");
	    loginpage.getUsernameField().sendKeys(USERNAME);
	    loginpage.getPasswordField().sendKeys(PASSWORD);
	    loginpage.getLoginButton().click();
	    Select chooselocation = new Select(searchHotelPage.getLocationfield());
	    chooselocation.selectByVisibleText("Sydney");
		searchHotelPage.getCheckinDatefield().clear();
		searchHotelPage.getCheckinDatefield().sendKeys("29/10/2025");
		searchHotelPage.getCheckoutDatefield().clear();
		searchHotelPage.getCheckoutDatefield().sendKeys("30/10/2025");	
		searchHotelPage.getSearchButton().click();
		String hotelInResult=searchHotelPage.getLocation().getAttribute("value");
		Assert.assertEquals(hotelInResult, "Sydney");
		
	}
}
