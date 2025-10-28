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
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 }
	
//	public boolean Logo() {
//		WebElement logo = driver.findElement(By.xpath("//img[@src='img/Adactin-Logo.jpg' and @alt='Adactin Group' ]"));
//		if(logo.isDisplayed()) {
//			System.out.println("Logo Present in the login page");
//		}
//		return logo.isDisplayed();
//	}
	public WebElement getUsernameField() {
			WebElement usernameField =driver.findElement(By.xpath("//input[@id='username']"));
			return usernameField;
	}
	public WebElement getPasswordField() {
		WebElement passwordField =driver.findElement(By.xpath("//input[@id='password']"));
		return passwordField;
	}
	public WebElement getLoginButton() {
		WebElement loginbutton =driver.findElement(By.xpath("//input[@id='login']"));
		return loginbutton;
	}	
}
