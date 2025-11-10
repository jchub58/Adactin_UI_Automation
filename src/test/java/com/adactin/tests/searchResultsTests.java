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
import com.adactin.flows.HotelBookingFlow;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SearchHotelPage;
import com.adactin.pages.SearchResultsPage;
import com.adactin.utils.ConfigReader;

public class searchResultsTests extends Basetest {
	SearchResultsPage searchResultsPage;
	HotelBookingFlow hotelBookingFlow;
	
	@BeforeMethod
	public void pageContext() {
		searchResultsPage=new SearchResultsPage(driver);
		hotelBookingFlow =new HotelBookingFlow(driver);
	}

	@Test
	public void vrerifySearchResults() throws IOException, InterruptedException {
		
		LocalDate today = LocalDate.now();
	    int totalCheckinDays = 7;
	    String locationWanted="Sydney";
	    String roomsWanted="2";
	    String roomType = "Standard";
	   
		LocalDate futureDate = LocalDate.now().plusDays(totalCheckinDays);
		String checkinDate=today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String checkOutDate=futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    
		hotelBookingFlow.login();
		hotelBookingFlow.searchHotel(locationWanted, roomsWanted, roomType, checkinDate, checkOutDate, totalCheckinDays);

		String pricePerNight = searchResultsPage.getPricePerNightField().getAttribute("value");
		String[] parts = pricePerNight.split(" ");
		int amount = Integer.parseInt(parts[2]);
		int totalAmount =(totalCheckinDays*amount*Integer.parseInt(roomsWanted));
	
		Assert.assertEquals(searchResultsPage.getLocationField().getAttribute("value"), locationWanted);
		Assert.assertEquals(searchResultsPage.getArrivalDateField().getAttribute("value"), checkinDate);
		Assert.assertEquals(searchResultsPage.getDepartureDateField().getAttribute("value"), checkOutDate);
		Assert.assertTrue(searchResultsPage.getRoomsField().getAttribute("value").contains(roomsWanted));
		Assert.assertEquals(searchResultsPage.getRoomTypeField().getAttribute("value"), roomType);
		Assert.assertEquals(searchResultsPage.getTotalPriceField().getAttribute("value"),"AUD"+" "+"$"+" "+totalAmount);
	}
}
