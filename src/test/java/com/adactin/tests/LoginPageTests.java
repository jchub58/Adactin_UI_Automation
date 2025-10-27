package com.adactin.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.Basetest;
import com.adactin.pages.LoginPage;

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
		public void verifyLogin() throws IOException {
			Assert.assertEquals(loginpage.login(),"Adactin.com - Search Hotel");
		}
}
