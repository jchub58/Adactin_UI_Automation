package com.adactin.tests;

import static org.testng.Assert.assertTrue;

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
import com.adactin.pages.BookAHotelPage;
import com.adactin.pages.BookingConfirmationPage;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SearchHotelPage;
import com.adactin.pages.SearchResultsPage;
import com.adactin.utils.ConfigReader;

public class BookingConfirmationTests extends Basetest {
 
	BookingConfirmationPage bookingConfirmationPage;
	HotelBookingFlow hotelBookingFlow;
	
	@BeforeMethod
	public void pageContext() {
		bookingConfirmationPage=new BookingConfirmationPage(driver);
		hotelBookingFlow=new HotelBookingFlow(driver);
	}
	
	@Test
	public void VerifyBookingConfirmation() throws InterruptedException, IOException {
		
	    int totalCheckinDays = 7;
	    String locationWanted="Sydney";
	    String roomsWanted="2";
	    String roomType = "Standard";
	    String hotel="Hotel Cornice";
	    String FirstName="test";
	    String LastName="user";
	    String BillingAddress= "Dummy Address";
	    String cardCVV="222", CreditCardNumber="1111111111111111",CreditCardType="American Express",ExpiryMonth="May",expiryYear="2026";
	    
	    LocalDate today = LocalDate.now();
		LocalDate futureDate = LocalDate.now().plusDays(totalCheckinDays);
		String checkinDate=today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String checkOutDate=futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    
	    
		hotelBookingFlow.login();
		hotelBookingFlow.searchHotel(locationWanted, roomsWanted, roomType, checkinDate, checkOutDate, totalCheckinDays);
		hotelBookingFlow.selectHotelAndContinue();
		hotelBookingFlow.bookHotel(FirstName, LastName, BillingAddress, cardCVV, CreditCardNumber, CreditCardType, ExpiryMonth, expiryYear);
		
		
		Assert.assertTrue(bookingConfirmationPage.getOrderNumberLabel().isDisplayed(),"OrderNo.field is Displayed");
		Assert.assertFalse(bookingConfirmationPage.getOrderNumber().isBlank(),"Order No. is Gnerated - "+ bookingConfirmationPage.getOrderNumber());
	}
}
