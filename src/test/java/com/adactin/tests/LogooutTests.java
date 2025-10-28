package com.adactin.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.pages.LoginPage;
import com.adactin.pages.LogoutPage;
import com.adactin.utils.ConfigReader;

	public class LogooutTests extends Basetest{
		
		LogoutPage logoutpage;
		LoginPage loginpage;
		
		@BeforeMethod
		public void pagecontext(){
			logoutpage=new LogoutPage(driver);
			loginpage=new LoginPage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		@Test
		public void verifySuccessfullogout() throws IOException {
			boolean logoutpass=false;
			
			Properties prop = ConfigReader.getPropertyObject();
		    String USERNAME = prop.getProperty("USERNAME");
		    String PASSWORD = prop.getProperty("PASSWORD");
		    loginpage.getUsernameField().sendKeys(USERNAME);
		    loginpage.getPasswordField().sendKeys(PASSWORD);
		    loginpage.getLoginButton().click();			
			logoutpage.getlogoutButton().click();
			
			String logoutmsg= logoutpage.logoutMessage();
			if (driver.getTitle().contains("Adactin.com - Logout") && logoutmsg.contains("You have successfully logged out. Click here to login again")) {
				logoutpass=true;
			}
			Assert.assertTrue(logoutpass);
		}
		
}
