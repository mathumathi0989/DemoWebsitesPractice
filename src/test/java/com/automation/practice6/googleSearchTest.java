package com.automation.practice6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class googleSearchTest {

	WebDriver driver = DriverSingleton.getDriver();
	@Test
	public void googleSe() throws Exception {
		driver.get("http://www.google.com");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("G43f7e")));
		List<WebElement> li = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		
		for (int i = 0; i <=li.size()-1; i ++) {
			String se = li.get(i).getText();
			System.out.println(se);
			if (se.contains("selenium foods")) {
				li.get(i).click();
				System.out.println("Page navigated");
			
			}
	
	
	}
		
	}

}
