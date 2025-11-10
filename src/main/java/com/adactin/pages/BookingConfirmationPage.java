package com.adactin.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingConfirmationPage {
	private WebDriver driver;
	public BookingConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getOrderNumberLabel() {
		return driver.findElement(By.xpath("//td[contains(text(),'Order No.')]"));
	}
	public String getOrderNumber() {
		return driver.findElement(By.xpath("//input[@id='order_no']")).getAttribute("value");
	}
}
