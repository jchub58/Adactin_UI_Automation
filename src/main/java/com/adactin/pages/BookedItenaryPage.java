package com.adactin.pages;

import org.openqa.selenium.WebDriver;

public abstract class BookedItenaryPage {
	private WebDriver driver;
	public BookedItenaryPage(WebDriver driver) {
		this.driver=driver;
	}
//	
//	public String getOrderId() {
//		List<WebElement> orders=driver.findElements(By.xpath("(//input[contains(@id,'order_id')])"));
//		for (WebElement orderNumberField : orders) {
//			orderNumberField[orders.indexOf(orders)]
//		}
//		
//		return "";
//	}
	
	
	//form[@id='booked_form']/table/tbody/tr[2]/td/table/tbody/tr   ---locates a table row (Record of an order)
	public abstract String getCancelOrderButton();
	public abstract String getHotelName();
	public abstract String getLocation();
	public abstract String getNumberOfRooms();
	public abstract String getFIrstName();
	public abstract String getLastName();
	public abstract String getArrivalDate();
	public abstract String getDepartureDate();
	public abstract String NumberOfDays();
	public abstract String getRoomType();
	public abstract String getPricePerNight();
	public abstract String getTotalPrice();
}
