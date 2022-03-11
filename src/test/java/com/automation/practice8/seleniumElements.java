package com.automation.practice8;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class seleniumElements {

	WebDriver driver = DriverSingleton.getDriver();
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());;
	@BeforeMethod
	public void browser() {
		driver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");
	}
	@Test(enabled = false)
	public void draggable() throws Exception {
		driver.findElement(By.xpath("//div[@class='row']/div[1]/ul[@class='boxed_style block']/li[1]")).click();
		driver.switchTo().window(tabs.get(1));
		String value = driver.findElement(By.xpath("//h1[contains(text(),'Draggable ')]")).getText();
		System.out.println(value);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active']/a")));
		Actions a = new Actions(driver);
		//Default Functionality
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]")));
		Thread.sleep(2000);
		WebElement drag = driver.findElement(By.xpath("//p[contains(text(),'Drag me around')]/parent::div"));
		a.dragAndDropBy(drag, 235, 49).perform();
		driver.switchTo().defaultContent();
		//Constrain Movement
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='container responsive-tabs-default']/div/ul/li[2]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]")));
		Thread.sleep(2000);
		WebElement drag1 = driver.findElement(By.xpath("//p[contains(text(),'I can be dragged only vertically')]/parent::div"));
		a.dragAndDropBy(drag1, 0,50).perform();
		WebElement drag2 = driver.findElement(By.xpath("//p[contains(text(),'I can be dragged only horizontally')]/parent::div"));
		System.out.println(drag2.getText());
		Thread.sleep(2000);
		a.dragAndDropBy(drag2, 50,0).perform();
		driver.switchTo().defaultContent();
	}
	@Test(enabled = true)
public void droppable() throws Exception {
		driver.findElement(By.xpath("//div[@class='row']/div[1]/ul[@class='boxed_style block']/li[2]")).click();
		driver.switchTo().window(tabs.get(2));
		String value = driver.findElement(By.xpath("//h1[contains(text(),'Droppable ')]")).getText();
		System.out.println(value);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active']/a")));
		Actions a = new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]")));
		Thread.sleep(2000);
		WebElement source = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]/parent::div"));
		System.out.println(source.getText());
		WebElement target = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]/parent::div"));
		System.out.println(target.getText());
		a.dragAndDrop(source, target).perform();
		
		
		
	}
	
public void resizable() {
	
}

public void selectable() {
	
}

public void sortable() {
	
}


public void accordion() {
	
}

public void autoComplete() {
	
}

public void datePicker() {
	
}

public void menu() {
	
}
public void slider() {
	
}
public void tabs() {
	
}
public void toolTip() {
	
}
public void frameWindows() {
	
}
public void submitBtn() {
	
}


public void dropDwn() {
	
}

public void registeration() {
	
}
public void alert() {
	
}

@AfterMethod
public void tearDown() {
	//driver.close();
}

}
