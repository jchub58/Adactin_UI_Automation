package com.adactin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage {

	private WebDriver driver;
	
	public SearchHotelPage(WebDriver driver) {
		 this.driver=driver;
	}
	
	public WebElement getLocationfield() {
		WebElement location =driver.findElement(By.id("location"));
		return location;
	}public WebElement getHotelfield() {
		WebElement hotel =driver.findElement(By.id("hotels"));
		return hotel;
	}
	public WebElement getRoomtypefield() {
		WebElement roomType =driver.findElement(By.id("room_type"));
		return roomType;
	}
	public WebElement getNumberofRoomsfield() {
		WebElement numberOfRooms =driver.findElement(By.id("room_nos"));
		return numberOfRooms;
	}
	public WebElement getCheckinDatefield() {
		WebElement checkinDate =driver.findElement(By.id("datepick_in"));
		return checkinDate;
	}public WebElement getCheckoutDatefield() {
		WebElement checkOutDate =driver.findElement(By.id("datepick_out"));
		return checkOutDate;
	}
	public WebElement getSearchButton() {
		WebElement search =driver.findElement(By.id("Submit"));
		return search;
	}
	public WebElement getResetButton() {
		WebElement reset =driver.findElement(By.id("Reset"));
		return reset;
	}
		
//	public void searchHotel(String location, String hotel, String roomType, String noOfRooms, String checkInDate, String checkOutDate) {
//
//	Select selectLocation = new Select(driver.findElement(By.id("location")));
//	selectLocation.selectByVisibleText(location);
//	
//	Select selectHotel = new Select(driver.findElement(By.id("hotels")));
//	selectHotel.selectByVisibleText(hotel);
//	
//	Select selectRoomType = new Select(driver.findElement(By.id("room_type")));
//	selectRoomType.selectByVisibleText(roomType);
//	
//	Select selectRooms = new Select(driver.findElement(By.id("room_nos")));
//	selectRooms.selectByVisibleText(noOfRooms);
//	
//	driver.findElement(By.id("datepick_in")).clear();
//	driver.findElement(By.id("datepick_in")).sendKeys(checkInDate);
//	driver.findElement(By.id("datepick_out")).clear();
//	driver.findElement(By.id("datepick_out")).sendKeys(checkOutDate);
//	
//	driver.findElement(By.id("Submit")).click();
//	}
	
	public String getCheckinError() {
		return driver.findElement(By.xpath("//span[@id='checkin_span']")).getText();
		
	}
	public String getCheckoutError() {
		String checkoutError = driver.findElement(By.xpath("//span[@id='checkout_span']")).getText();
		return checkoutError;
	}
}	
