package com.automation.practice2;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class signUpForm {

	WebDriver driver = DriverSingleton.getDriver();
	
	@Test
	public void signup() throws Exception {
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.findElement(By.name("firstname")).sendKeys("Mathumathi");
		driver.findElement(By.name("lastname")).sendKeys("Balakrishnan");
		driver.findElement(By.id("sex-1")).click();
		driver.findElement(By.id("exp-2")).click();
		driver.findElement(By.id("datepicker")).sendKeys("2/2/2022");
		driver.findElement(By.id("profession-1")).click();
		driver.findElement(By.id("tool-2")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");

	
		WebElement se = driver.findElement(By.id("continents"));
		Select s = new Select(se);
		s.selectByVisibleText("North America");
		
		WebElement se1 = driver.findElement(By.id("selenium_commands"));
		Select s1 = new Select(se1);
		s1.selectByVisibleText("Wait Commands");
		
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\mathu\\Desktop\\trial\\try.txt");
		
		driver.findElement(By.xpath("//div[@class='controls']/div[2]/div/a")).click();
		driver.navigate().back();
		
		driver.findElement(By.id("submit")).click();
		
		driver.quit();
	
		/*
		String fs = System.getProperty("C:\\Users\\mathu\\Desktop\\trial\\try.txt");
		StringSelection filepath = new StringSelection(fs);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
	*/	
	}
	
	
}
