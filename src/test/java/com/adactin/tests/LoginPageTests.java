package com.adactin.tests;

import java.io.IOException;
import java.util.Properties;

import org.checkerframework.checker.units.qual.h;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.flows.HotelBookingFlow;
import com.adactin.pages.LoginPage;
import com.adactin.utils.ConfigReader;

public class LoginPageTests extends Basetest {
	
	LoginPage loginpage;
	HotelBookingFlow hotelBookingFlow;
	
	@BeforeMethod
	public void pageContext() {
		loginpage =new LoginPage(driver);
		hotelBookingFlow=new HotelBookingFlow(driver);
	}
	
//		@Test
//		public void verifyLogo() {
//			Assert.assertTrue(loginpage.Logo());
//		}
	@Test
		public void login() throws IOException, InterruptedException {
			hotelBookingFlow.login();
			Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
		}
}
