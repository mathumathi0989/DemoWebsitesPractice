package com.automation.practice5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;


public class DataTable {

	WebDriver driver = DriverSingleton.getDriver();
	public String struct = "Burj Khalifa";
	public String colValue = "Height";
	public List<String> li = new ArrayList<String>();	
	
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
	@Test(enabled=false)
	public void dynamicTB() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		List<WebElement> rowList = table.findElements(By.tagName("tr"));
		System.out.println("Number of rows: "+rowList.size());
		
		List<WebElement> headerList = null;
		List<WebElement> colList = null;
		
		for (WebElement row: rowList) {
			System.out.println();
			headerList = row.findElements(By.tagName("th"));
			
			for (WebElement header : headerList) {
				System.out.println(header.getText());
				colList = row.findElements(By.tagName("td"));
				for (WebElement col: colList) {
					System.out.println(col.getText());
				}
			}
		}
		System.out.println("Number of headers :" +headerList.size());
		System.out.println("Number of columns :" +colList.size());
	}
	
	
	//Verify that Burj Khalifa has a height of 829m with Selenium
	@Test(enabled=false)
	public void sharanyaburjHeight() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		List<WebElement> rowList = table.findElements(By.tagName("tr"));
		System.out.println("Number of rows: "+rowList.size());
		for (WebElement row : rowList) {
			System.out.println();
			if(row.getText().contains("Khalifa")) {
				List<WebElement> li =driver.findElements(By.xpath("//table[@summary='Sample Table']/thead/tr/th"));
				System.out.println(li.size());
				for(int i=0;i<li.size();i++) {
					String column=li.get(i).getText();
					if(column.contains("City")) {
						String height=row.findElement(By.xpath("(//table[@class='tsc_table_s13']/tbody/tr/td["+i+"])[1]")).getText();
						System.out.println(height);
					}
				}
			}					
			}
			
	
			
		
		
		}
	
	@Test(enabled=false)
	public void khalifaHeight() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//th"));
		for (int i=0; i <rowList.size(); i++) {
			String row = rowList.get(i).getText();
			if(row.equalsIgnoreCase(struct)) {
				List<WebElement> colList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead//th"));
				for (int j=0; j<colList.size(); j++) {
					String col = colList.get(j).getText();
						if(col.equalsIgnoreCase(colValue)) {
							String value = driver.findElement(By.xpath("//table[@class='tsc_table_s13']//th[contains(text(),'"+row+"')]/following-sibling::td["+j+"]")).getText();
							System.out.println(row +" height is "+value);
							break;
						}
					}
				
			}
		
		}
		
	
	
	}

	//Verify that 6th row of the table (Last Row) has only two columns with Selenium
	@Test(enabled=false)
	public void lastrow() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List<WebElement> last = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tfoot/tr/*"));
		for (WebElement rowLast : last) {
			System.out.println(rowLast.getText());
			System.out.println();
		}
		System.out.println("Last row of the table has only " +last.size() +" columns");
		
		
		
	}
	
	
	
	//Find the tallest structure in the table with Selenium
	@Test
	public void tall() {
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//th"));
		List<WebElement> colList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead//th"));
		for(int i =1; i<=rowList.size(); i++) {
					for(int j=1;j<colList.size();j++)
					{
						String col = colList.get(j).getText();
						if (col.equalsIgnoreCase("Height")) {
							List<WebElement> value = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td["+j+"]"));
							for(int k=0; k<value.size();) {
								String high = value.get(k).getText();
								
								li.add(high);
								
								break;
							}
						}
					}
		}
		Collections.sort(li, Collections.reverseOrder());
		
		System.out.println(li);
		System.out.println("The Tallest structure in the table is " +li.get(0));
	
	}
	
	
	
}
