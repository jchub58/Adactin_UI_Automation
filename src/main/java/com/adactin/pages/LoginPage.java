package com.adactin.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.adactin.utils.ConfigReader;


public class LoginPage {
	
	private WebDriver driver;
	
	 public LoginPage(WebDriver driver) {
		 this.driver=driver;
	 }
	
//	public boolean Logo() {
//		WebElement logo = driver.findElement(By.xpath("//img[@src='img/Adactin-Logo.jpg' and @alt='Adactin Group' ]"));
//		if(logo.isDisplayed()) {
//			System.out.println("Logo Present in the login page");
//		}
//		return logo.isDisplayed();
//	}
	
	public String login() throws IOException {
		
		Properties prop = ConfigReader.getPropertyObject();
	    String USERNAME = prop.getProperty("USERNAME");
	    String PASSWORD = prop.getProperty("PASSWORD");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement username =driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(USERNAME);
		WebElement password =driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(PASSWORD);
		WebElement loginbutton =driver.findElement(By.xpath("//input[@id='login']"));
		loginbutton.click();
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	
}
