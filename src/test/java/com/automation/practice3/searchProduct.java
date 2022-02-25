package com.automation.practice3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class searchProduct {
WebDriver driver = DriverSingleton.getDriver();

//Automate 'Search Product' feature of e-commerce website with Selenium.
@Test
public void search() throws Exception {
	driver.get("http://automationpractice.com/index.php");
	Actions a = new Actions (driver);
	WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
	a.moveToElement(women).build().perform();
	driver.findElement(By.xpath("(//a[@title='T-shirts'])[1]")).click();
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,700)");
	
	String prod_Name = driver.findElement(By.xpath("//div[@class='product-container']/div[2]/h5/a")).getText();
	Reporter.log("First Product Name: " +prod_Name);
	String prod_Price = driver.findElement(By.xpath("//div[@class='product-container']/div[2]/div[@class='content_price']")).getText();
	Reporter.log("First Product Price: " +prod_Price);
	driver.findElement(By.id("search_query_top")).sendKeys(prod_Name);
	
	driver.findElement(By.name("submit_search")).click();
	Thread.sleep(2000);
	String search_Name = driver.findElement(By.xpath("//div[@class='right-block']/h5/a")).getText();
	Reporter.log("Searched product Name: " +search_Name);
	String search_Price = driver.findElement(By.xpath("//div[@class='right-block']/div[@class='content_price']")).getText();
	Reporter.log("Searched product price: " +search_Price);
	
	if((prod_Name.equalsIgnoreCase(search_Name) && (prod_Price.equalsIgnoreCase(search_Price))))
	{		System.out.println("Both the product names and prices are equal");
		Reporter.log("Both the product names and prices are equal");
		}
	else {
		System.out.println("Both the product names and prices are not equal");
		Reporter.log("Both the product names and prices are not equal");
	}
	
	driver.quit();
	}

	
}
