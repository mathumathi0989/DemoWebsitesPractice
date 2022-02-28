package com.automation.practice6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class googleSearch {

	WebDriver driver = DriverSingleton.getDriver();
	@Test
	public void googleSe() throws Exception {
		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium tutorial");
		WebDriverWait wait = new WebDriverWait(driver,30);
		
	//	Thread.sleep(1000);
		List<WebElement> li = driver.findElements(By.className("G43f7e"));
		for (int i=0; i <=li.size()-1; i++) {
			System.out.println(li.get(i).getText());
		}
		
		
		
	}
	
	
}
