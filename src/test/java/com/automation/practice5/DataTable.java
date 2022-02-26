package com.automation.practice5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;


public class DataTable {

	WebDriver driver = DriverSingleton.getDriver();
	
	public void staticTB() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
		
		List<WebElement> rowsList = table.findElements(By.tagName("tr"));
		System.out.println("Total Number of rows: "+rowsList.size());
		
		List<WebElement> colList = null;
		
		for(WebElement row : rowsList ) {
			System.out.println();
			colList = row.findElements(By.tagName("td"));
			for (WebElement col : colList) {
				System.out.println(col.getText()+",");
			}
		}
		
		
		
	}
	
	
	public void staticTB1() {
		driver.get("https://www.softwaretestingo.com/handle-static-web-table-in-selenium/");
		WebElement table = driver.findElement(By.xpath("//div[@class='entry-content']/table"));
		
		List<WebElement> rowList = table.findElements(By.tagName("tr"));
		System.out.println("Number of rows: " +rowList.size());
		
		List<WebElement> colList1 = null;
		
		for (WebElement row : rowList) {
			System.out.println();
			colList1 = row.findElements(By.tagName("td"));

			for (WebElement col : colList1) {
				System.out.println(col.getText());
			}
		}
		System.out.println("Number of columns: "+colList1.size());
		
	}
	
	
	//Verify that there are only 4 structure values present in the demo table 2.
	@Test
	public void dynamicTB() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		
		List<WebElement> rowList = table.findElements(By.tagName("tr"));
		System.out.println("Number of rows: "+rowList.size());
		
		List<WebElement> colList = null;
		
		for (WebElement row : rowList) {
			System.out.println();
			colList = row.findElements(By.tagName("td"));
			for (WebElement col : colList) {
				System.out.println(col.getText());
			}
		}
		
		System.out.println("Number of columns: "+colList.size());
		
		
	}
	
	
	//Verify that Burj Khalifa has a height of 829m with Selenium

	//Verify that 6th row of the table (Last Row) has only two columns with Selenium
	//Find the tallest structure in the table with Selenium
	
	
	
	
}
