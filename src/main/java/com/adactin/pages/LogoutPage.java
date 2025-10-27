package com.adactin.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	private WebDriver driver;
	LoginPage loginpage;
	public LogoutPage (WebDriver driver) {
		this.driver=driver;
	}
	public String logout() throws IOException{
		loginpage = new LoginPage(driver);
		loginpage.login();
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
		return driver.getTitle();
	}
	public String LogoutMessage() throws IOException {
		this.logout();
		String logoutmsg = driver.findElement(By.xpath("//td[@class='reg_success']")).getText();
		return logoutmsg;
	} 
	
}
