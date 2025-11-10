package com.adactin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookAHotelPage {

	private WebDriver driver;
	
	public BookAHotelPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getHotelName() {
		return driver.findElement(By.xpath("//input[@id='hotel_name_dis']")).getAttribute("value");
	}	public String getLocation() {
		return driver.findElement(By.xpath("//input[@id='location_dis']")).getAttribute("value");
	}public String getRoomType() {
		return driver.findElement(By.xpath("//input[@id='room_type_dis']")).getAttribute("value");
	}public String getNumberOfRooms() {
		return driver.findElement(By.xpath("//input[@id='room_num_dis']")).getAttribute("value");
	}public String getToatlDays() {
		return driver.findElement(By.xpath("//input[@id='total_days_dis']")).getAttribute("value");
	}public String getPricePerNight() {
		return driver.findElement(By.xpath("price_night_dis")).getAttribute("value");
	}public String getTotalPrice() {
		return driver.findElement(By.xpath("//input[@id='total_price_dis']")).getAttribute("value");
	}public String getGst() {
		return driver.findElement(By.xpath("//input[@id='gst_dis']")).getAttribute("value");
	}public String getFinalBilledPrice() {
		return driver.findElement(By.xpath("//input[@id='final_price_dis']")).getAttribute("value");
	}public WebElement getFirstNameField() {
		return driver.findElement(By.xpath("//input[@id='first_name']"));
	}public WebElement getLastNameField() {
		return driver.findElement(By.xpath("//input[@id='last_name']"));
	}public WebElement getBillingAddressField() {
		return driver.findElement(By.xpath("//textarea[@id='address']"));
	}public WebElement getCreditCardNumberField() {
		return driver.findElement(By.xpath("//input[@id='cc_num']"));
	}public WebElement getCreditCardTypeField() {
		return driver.findElement(By.xpath("//select[@id='cc_type']"));
	}public WebElement getExpiryDateMonth() {
		return driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
	}public WebElement getExpiryDateYear() {
		return driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
	}public WebElement getCvvField() {
		return driver.findElement(By.xpath("//input[@id='cc_cvv']"));
	}public WebElement getBookNowButton() {
		return driver.findElement(By.xpath("//input[@id='book_now']"));
	}public WebElement getCancelButton() {
		return driver.findElement(By.xpath("//input[@id='cancel']"));
	}
}
