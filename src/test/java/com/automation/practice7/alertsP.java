package com.automation.practice7;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class alertsP {

	WebDriver driver = DriverSingleton.getDriver();
	WebDriverWait wait = new WebDriverWait(driver,60);
	
	@BeforeMethod
	public void browser() {
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
	}
	
	@Test(enabled=false)
	public void javaAlert() throws Exception {
		driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		String aler_message = a.getText();
		System.out.println(aler_message);
		Reporter.log(aler_message);
		a.accept();
	}
	
	@Test(enabled=false)
	public void javaTimingAlert() {
		//driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.findElement(By.id("timingAlert")).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		String aler_message = a.getText();
		System.out.println(aler_message);
		a.accept();
		
	}
	
	@Test(enabled=false)
	public void javaAlertText() {
		WebElement buzz = driver.findElement(By.xpath("//span[@class='timer']"));
		wait.until(ExpectedConditions.textToBe(By.id("clock"), "Buzz Buzz"));
		System.out.println(buzz.getText());	
	}
	
	@Test
	public void dragMe() throws Exception {
		try {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		WebElement dragMe = driver.findElement(By.xpath("//button[@id='draga']"));
		System.out.println(dragMe.getText());
		WebElement dragTo = driver.findElement(By.xpath("//button[@id='dragb']"));
		System.out.println(dragTo.getText());
		Thread.sleep(3000);
		//Dragand drop wont work if its html5
		JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				                    + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				                    + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				                    + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				                    + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				                    + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				                    + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				                    + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				                    + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				                    + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				                    + "var dropEvent = createEvent('drop');\n"
				                    + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				                    + "var dragEndEvent = createEvent('dragend');\n"
				                    + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				                    + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				                    + "simulateHTML5DragAndDrop(source,destination);", dragMe, dragTo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	


	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
