package com.adactin.tests;

import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.pages.LogoutPage;

	public class LogooutTests extends Basetest{
		
		LogoutPage logoutpage;
		@BeforeMethod
		public void pagecontext(){
			logoutpage=new LogoutPage(driver);
		}
		@Test
		public void verifyLogoutPgeRedirect() throws IOException {
			Assert.assertEquals("Adactin.com - Logout", logoutpage.logout());
		}
		@Test
		public void verifylogoutmsg() throws IOException {
			Assert.assertEquals("You have successfully logged out. Click here to login again", logoutpage.LogoutMessage());
		}
		
}
