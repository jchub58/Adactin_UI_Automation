package com.adactin.tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.pages.LoginPage;
import com.adactin.utils.ConfigReader;

public class LoginPageTests extends Basetest {
	
	LoginPage loginpage;
	
	@BeforeMethod
	public void pageContext() {
		loginpage =new LoginPage(driver);
	}
	
//		@Test
//		public void verifyLogo() {
//			Assert.assertTrue(loginpage.Logo());
//		}
	@Test
		public void login() throws IOException {
			Properties prop = ConfigReader.getPropertyObject();
		    String USERNAME = prop.getProperty("USERNAME");
		    String PASSWORD = prop.getProperty("PASSWORD");
		    loginpage.getUsernameField().sendKeys(USERNAME);
		    loginpage.getPasswordField().sendKeys(PASSWORD);
		    loginpage.getLoginButton().click();
			String pageTitle=driver.getTitle();
			Assert.assertEquals(pageTitle,"Adactin.com - Search Hotel");
		}
}
