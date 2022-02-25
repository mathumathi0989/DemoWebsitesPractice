package com.automation.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {

public static WebDriver driver  ;
	
	public static WebDriver getDriver() {
		if(driver !=null ) return driver ;
		
	System.setProperty("webdriver.chrome.driver", "D:\\MathuConcepts\\practice1\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
		
	return driver ;
	}
	
	private DriverSingleton() {
	};
	 
}
