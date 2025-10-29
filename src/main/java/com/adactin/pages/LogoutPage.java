package com.adactin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	private WebDriver driver;
	
	public LogoutPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getlogoutButton() {
		WebElement logoutbutton = driver.findElement(By.xpath("//a[text()='Logout']"));
		return logoutbutton;
	}
	public String logoutMessage() {
		String logoutmsg = 
				driver.findElement(By.xpath("//td[@class='reg_success']")).getText();
		return logoutmsg;
	}
	
//	public String logout() throws IOException{
//		loginpage = new LoginPage(driver);
//		loginpage.login();
//		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
//		logout.click();
//		return driver.getTitle();
//	}	
}
