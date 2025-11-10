package com.adactin.tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.flows.HotelBookingFlow;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SearchHotelPage;
import com.adactin.utils.ConfigReader;

public class SearchHotelPageTests extends Basetest {
	HotelBookingFlow hotelBookingFlow;
	SearchHotelPage searchHotelPage;
	@BeforeMethod
	public void pageContext() {
		hotelBookingFlow=new HotelBookingFlow(driver);
		searchHotelPage=new SearchHotelPage(driver);
	}
	
	@Test
	public void VerifyCheckinFieldMsg() throws IOException {
		
		String checkInDate="28/10/2025";
		String CheckOutDate="25/10/2025";
		
	    hotelBookingFlow.login();
	    hotelBookingFlow.searchHotel(null, null, null, checkInDate, CheckOutDate, -3);
		
		
		boolean checkinValidation=false;
		if (searchHotelPage.getCheckinError().contains("Check-In Date shall be before than Check-Out Date")) {
			checkinValidation=true;
		}
		Assert.assertTrue(checkinValidation);
	}
}
