package com.automation.practice7;

import java.awt.Window;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class windowHandles {

	WebDriver driver = DriverSingleton.getDriver();
	
	@BeforeMethod
	public void browser() {
		driver.get("http://www.seleniumframework.com/Practiceform/");
	}
	
	@Test(enabled=false)
	public void newBrowserWindow() {
		WebElement browser = driver.findElement(By.xpath("//button[@id='button1']"));
		browser.click();
		String main = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window: windows) {
			driver.switchTo().window(window);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			driver.switchTo().window(main);
		}
		
	}
	
	@Test(enabled=true)
	public void newMessageWindow() throws Exception {
		WebElement message = driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]"));
		message.click();
		try {
			
			//String parent = driver.getWindowHandle();
Set<String> windows = driver.getWindowHandles();
System.out.println(windows.size());
Iterator<String> ite = windows.iterator();
String parent =	ite.next();
System.out.println(parent);
String child = ite.next();
System.out.println(child);
driver.switchTo().window(child);
Thread.sleep(2000);
JavascriptExecutor js = (JavascriptExecutor) driver;

//Enter Techndeck in the loginName field on the Office Depot Business website homepage using Javascipt Executor
String text = js.executeScript("return document.getElementBytagName('body').value").toString();

System.out.println(text);

//System.out.println(driver.findElement(By.tagName("body")).getText());

//String current = driver.getWindowHandle();
//System.out.println(current);
//System.out.println(driver.getPageSource());

//String childText = driver.findElement(By.xpath("//body")).getText();
//System.out.println(childText);
//Thread.sleep(1000);

//driver.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Test(enabled=false)
	public void newBrowserTab() {
		WebElement message = driver.findElement(By.xpath("//button[contains(text(),'New Browser Tab')]"));
		message.click();
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    System.out.println(driver.getTitle());
		    driver.close();
		    driver.switchTo().window(tabs.get(0));
		    System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void tear() {
	//	driver.quit();
	}
}
