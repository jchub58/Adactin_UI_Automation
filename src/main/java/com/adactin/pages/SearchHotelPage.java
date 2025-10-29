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
		WebElement location =driver.findElement(By.id("hotels"));
		return location;
	}
	public WebElement getRoomtypefield() {
		WebElement location =driver.findElement(By.id("room_type"));
		return location;
	}
	public WebElement getNumberofRoomsfield() {
		WebElement location =driver.findElement(By.id("room_nos"));
		return location;
	}
	public WebElement getCheckinDatefield() {
		WebElement location =driver.findElement(By.id("datepick_in"));
		return location;
	}public WebElement getCheckoutDatefield() {
		WebElement location =driver.findElement(By.id("datepick_out"));
		return location;
	}
	public WebElement getSearchButton() {
		WebElement location =driver.findElement(By.id("Submit"));
		return location;
	}
	public WebElement getResetButton() {
		WebElement location =driver.findElement(By.id("Reset"));
		return location;
	}
	public WebElement getLocation() {
		WebElement location=driver.findElement(By.xpath("//input[contains(@id,'location')]"));
		return location;
	}
	
	//input[@id="location_0"]
	
	public void searchHotel(String location, String hotel, String roomType, String noOfRooms, String checkInDate, String checkOutDate) {

	Select selectLocation = new Select(driver.findElement(By.id("location")));
	selectLocation.selectByVisibleText(location);
	
	Select selectHotel = new Select(driver.findElement(By.id("hotels")));
	selectHotel.selectByVisibleText(hotel);
	
	Select selectRoomType = new Select(driver.findElement(By.id("room_type")));
	selectRoomType.selectByVisibleText(roomType);
	
	Select selectRooms = new Select(driver.findElement(By.id("room_nos")));
	selectRooms.selectByVisibleText(noOfRooms);
	
	driver.findElement(By.id("datepick_in")).clear();
	driver.findElement(By.id("datepick_in")).sendKeys(checkInDate);
	driver.findElement(By.id("datepick_out")).clear();
	driver.findElement(By.id("datepick_out")).sendKeys(checkOutDate);
	
	driver.findElement(By.id("Submit")).click();
	}
	
	public String getCheckinError() {
		return driver.findElement(By.xpath("//span[@id='checkin_span']")).getText();
		
	}
	public String getCheckoutError() {
		String checkoutError = driver.findElement(By.xpath("//span[@id='checkout_span']")).getText();
		return checkoutError;
	}
}	
