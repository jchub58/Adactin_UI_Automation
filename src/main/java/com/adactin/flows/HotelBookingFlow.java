package com.adactin.flows;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.adactin.pages.BookAHotelPage;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SearchHotelPage;
import com.adactin.pages.SearchResultsPage;
import com.adactin.utils.ConfigReader;

public class HotelBookingFlow {
	
	 	private LoginPage loginPage;
	    private SearchHotelPage searchHotelPage;
	    private SearchResultsPage searchResultsPage;
	    private BookAHotelPage bookAHotelPage;
	    private WebDriver driver;

	    public HotelBookingFlow(WebDriver driver) {
	        this.driver = driver;
	        loginPage = new LoginPage(driver);
	        searchHotelPage = new SearchHotelPage(driver);
	        searchResultsPage = new SearchResultsPage(driver);
	        bookAHotelPage = new BookAHotelPage(driver);
	    }

	    public void login() throws IOException {
	    	Properties prop = ConfigReader.getPropertyObject();
		    String USERNAME = prop.getProperty("USERNAME");
		    String PASSWORD = prop.getProperty("PASSWORD");
	        loginPage.getUsernameField().sendKeys(USERNAME);
	        loginPage.getPasswordField().sendKeys(PASSWORD);
	        loginPage.getLoginButton().click();
	    }

	    public void searchHotel(String location, String rooms, String roomType, String checkinDate, String checkoutDate ,int totalCheckinDays) {
	    	Select chooselocation = new Select(searchHotelPage.getLocationfield());
		    chooselocation.selectByValue(location);
			searchHotelPage.getCheckinDatefield().clear();
			searchHotelPage.getCheckinDatefield().sendKeys(checkinDate);
			searchHotelPage.getCheckoutDatefield().clear();
			searchHotelPage.getCheckoutDatefield().sendKeys(checkoutDate);	
			Select chooseRooms= new Select(searchHotelPage.getNumberofRoomsfield());
			chooseRooms.selectByValue(rooms);
			Select chooseRoomType = new Select(searchHotelPage.getRoomtypefield());
			chooseRoomType.selectByVisibleText(roomType);
			searchHotelPage.getSearchButton().click();
			
	    }
	    public void selectHotelAndContinue() {
	        searchResultsPage.getradioButton().click();
	        searchResultsPage.getContinueButton().click();
	    }
	    public void bookHotel(String FirstName,String LastName, String billingAddress, String cardCvv  ,String CreditCardNumber,String CreditCardType, String ExpiryMonth, String expiryYear) {
	    	bookAHotelPage.getFirstNameField().sendKeys(FirstName);
			bookAHotelPage.getLastNameField().sendKeys(LastName);
			bookAHotelPage.getBillingAddressField().sendKeys(billingAddress);
			bookAHotelPage.getCreditCardNumberField().sendKeys(CreditCardNumber);
			Select chooseCreditCardType=new Select(bookAHotelPage.getCreditCardTypeField());
			chooseCreditCardType.selectByVisibleText(CreditCardType);
			Select chooseExpiryMonth=new Select(bookAHotelPage.getExpiryDateMonth());
			chooseExpiryMonth.selectByVisibleText(ExpiryMonth);
			Select chooseExpiryYear=new Select(bookAHotelPage.getExpiryDateYear());
			chooseExpiryYear.selectByVisibleText(expiryYear);
			bookAHotelPage.getCvvField().sendKeys(cardCvv);
			bookAHotelPage.getBookNowButton().click();
		}

}
