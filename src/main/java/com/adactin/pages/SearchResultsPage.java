package com.adactin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	
	private WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getHotelField() {
		WebElement hotelfield =driver.findElement(By.xpath("//input[@id='hotel_name_1']"));
		return hotelfield;
	}public WebElement getLocationField() {
		WebElement locationField = driver.findElement(By.xpath("//input[@id='location_1']"));
		return locationField;
	}public WebElement getRoomsField() {
		WebElement RoomsField = driver.findElement(By.xpath("//input[@id='rooms_1']"));
		return RoomsField;		
	}public WebElement getArrivalDateField() {
		WebElement ArrivalDate = driver.findElement(By.xpath("//input[@id='arr_date_1']"));
		return ArrivalDate;
	}public WebElement getDepartureDateField() {
		WebElement departureDate=driver.findElement(By.xpath("//input[@id='dep_date_1']"));
		return departureDate;
	}public WebElement getNumberOfDaysField() {
		WebElement numberOfDays=driver.findElement(By.xpath("//input[@id='no_days_1']"));
		return numberOfDays;
	}public WebElement getRoomTypeField() {
		WebElement roomType=driver.findElement(By.xpath("//input[@id='room_type_1']"));
		return roomType;
	}public WebElement getPricePerNightField() {
		WebElement pricePerNight=driver.findElement(By.xpath("//input[@id='price_night_1']"));
		return pricePerNight;
	}public WebElement getTotalPriceField() {
	WebElement totalPrice=driver.findElement(By.xpath("//input[@id='total_price_1']"));
	return totalPrice;
	}
}

