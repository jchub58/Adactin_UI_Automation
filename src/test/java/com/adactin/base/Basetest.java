package com.adactin.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.adactin.utils.ConfigReader;

public class Basetest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()throws IOException {
	
		Properties prop = ConfigReader.getPropertyObject();
	    String url = prop.getProperty("BUILD2_URL");
	    
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterMethod
	public void quitbrowser() {
		driver.quit();
//		if (driver != null) {
//            driver.quit();
//            System.out.println("Browser closed");
//		}
	}
}
