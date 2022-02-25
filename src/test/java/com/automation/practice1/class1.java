package com.automation.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class class1 {
	 
	private static final String AUTOMATION_PRACTICE_URL = "http://automationpractice.com/index.php?controller=contact";
	WebDriver driver = DriverSingleton.getDriver();
	
	@Test(priority = '1')
	public void title() {
		System.out.println("priority-1");
		driver.get(AUTOMATION_PRACTICE_URL);
		String actualTitle = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']")).getText();
		System.out.println(actualTitle);
		String ExpectedTitle = "CUSTOMER SERVICE - CONTACT US";
		Assert.assertEquals(actualTitle, ExpectedTitle );
	}
	
	@Test(priority = '2')
	public void sendMessage() throws Exception {
		System.out.println("priority-2");
		WebElement d = driver.findElement(By.xpath("//select[@id='id_contact']"));
		Select s = new Select(d);
		s.selectByValue("2");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mathumathi.b@gmail.com");
		driver.findElement(By.xpath("//input[@name='id_order']")).sendKeys("123434");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\Users\\mathu\\Desktop\\SQL-Cheat-Sheet.pdf");
		driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Hi! Hello");
		driver.findElement(By.xpath("//button[@name='submitMessage']")).click();
		Thread.sleep(7000);
	}
	
	@Test(priority='3')
	public void afterSubmit() {
		System.out.println("priority-3");
	//	String afterSubmit = driver.findElement(By.xpath("//p[contains(@class,'alert')]")).getText();
		String afterSubmit = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
		System.out.println(afterSubmit);
	}
	
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
}
