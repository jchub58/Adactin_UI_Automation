package com.adactin.tests;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SearchHotelPage;
import com.adactin.pages.SearchResultsPage;
import com.adactin.utils.ConfigReader;

public class searchResultsTests extends Basetest {
	SearchResultsPage searchResultsPage;
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	
	@BeforeMethod
	public void pageContext() {
		searchResultsPage=new SearchResultsPage(driver);
		loginPage=new LoginPage(driver);
		searchHotelPage=new SearchHotelPage(driver);
	}

	@Test
	public void vrerifySearchResults() throws IOException {
		Properties prop = ConfigReader.getPropertyObject();
	    String USERNAME = prop.getProperty("USERNAME");
	    String PASSWORD = prop.getProperty("PASSWORD");
	    loginPage.getUsernameField().sendKeys(USERNAME);
	    loginPage.getPasswordField().sendKeys(PASSWORD);
	    loginPage.getLoginButton().click();
	    
	    Select chooselocation = new Select(searchHotelPage.getLocationfield());
	    String locationWanted="Sydney";
	    chooselocation.selectByValue(locationWanted);
		searchHotelPage.getCheckinDatefield().clear();
		LocalDate today = LocalDate.now();
		LocalDate futureDate = LocalDate.now().plusDays(7);
		String checkinDate=today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String checkOutDate=futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		searchHotelPage.getCheckinDatefield().sendKeys(checkinDate);
		searchHotelPage.getCheckoutDatefield().clear();
		searchHotelPage.getCheckoutDatefield().sendKeys(checkOutDate);	
		Select chooseRooms= new Select(searchHotelPage.getNumberofRoomsfield());
		String roomsWanted="2";
		chooseRooms.selectByVisibleText(roomsWanted);
		searchHotelPage.getSearchButton().click();
		
	
		Assert.assertEquals(searchResultsPage.getLocationField().getAttribute("value"), locationWanted);
		Assert.assertEquals(searchResultsPage.getArrivalDateField().getAttribute("value"), checkinDate);
		Assert.assertEquals(searchResultsPage.getDepartureDateField().getAttribute("value"), checkOutDate);
		Assert.assertTrue(searchResultsPage.getRoomsField().getAttribute("value").contains(roomsWanted));
	}
}
