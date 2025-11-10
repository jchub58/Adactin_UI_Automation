package com.adactin.tests;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import com.adactin.base.Basetest;
import com.adactin.flows.HotelBookingFlow;
import com.adactin.pages.BookAHotelPage;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SearchHotelPage;
import com.adactin.pages.SearchResultsPage;
import com.adactin.utils.ConfigReader;

public class BookAHotelTests extends Basetest {
	BookAHotelPage bookAHotelpage;
	HotelBookingFlow hotelBooking;
	SearchResultsPage searchResultsPage;
	
	@BeforeMethod
	public void pageContext() {
		bookAHotelpage = new BookAHotelPage(driver);
		searchResultsPage=new SearchResultsPage(driver);
		hotelBooking=new HotelBookingFlow(driver);
	}
	
	@Test
	public void verifyDisabledFields() throws IOException, InterruptedException {
		//Variables
	    LocalDate today = LocalDate.now();
	    int totalCheckinDays = 7;
	    String locationWanted="Sydney";
	    String roomsWanted="2";
	    String roomType = "Standard";
	    String hotel="Hotel Cornice";
	   //Date Calculation
		LocalDate futureDate = LocalDate.now().plusDays(totalCheckinDays);
		String checkinDate=today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String checkOutDate=futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		//Test Starts
		hotelBooking.login();
		hotelBooking.searchHotel(locationWanted, roomsWanted, roomType, checkinDate, checkOutDate, totalCheckinDays);
		String pricePerNightString = searchResultsPage.getPricePerNightField().getAttribute("value");
		String[] priceParts = pricePerNightString.split(" ");
		int PricePerNight = Integer.parseInt(priceParts[2]);
		int totalAmount =(totalCheckinDays*PricePerNight*Integer.parseInt(roomsWanted));
		hotelBooking.selectHotelAndContinue();
		
		String finalPriceString=bookAHotelpage.getFinalBilledPrice();
		String[] parts = finalPriceString.split(" ");
		int FinalPrice = Integer.parseInt(parts[2]);
		
		Assert.assertEquals(bookAHotelpage.getHotelName(), hotel);
		Assert.assertEquals(bookAHotelpage.getLocation(), locationWanted);
		Assert.assertEquals(bookAHotelpage.getRoomType(), roomType);
		Assert.assertEquals(bookAHotelpage.getNumberOfRooms(),roomsWanted+" "+"Room(s)");
		Assert.assertEquals(bookAHotelpage.getToatlDays(), totalCheckinDays+" "+"Day(s)");
		Assert.assertEquals(bookAHotelpage.getPricePerNight(), pricePerNightString);
		Assert.assertEquals(searchResultsPage.getTotalPriceField().getAttribute("value"), totalAmount);
		Assert.assertEquals(FinalPrice, (totalAmount)+(totalAmount*10/100));
	}
	
}