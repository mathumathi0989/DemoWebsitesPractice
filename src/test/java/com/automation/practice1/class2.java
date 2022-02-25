package com.automation.practice1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class class2 {

	static WebDriver driver = DriverSingleton.getDriver();
		static String proceedValue;
		static String priceV;
		
	@Test (priority = 1)
 public void baseurl() throws Exception {
	driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	 jse.executeScript("window.scrollBy(0,1000)");
	 Thread.sleep(5000);
 }
	
@Test (priority = 2)
public void addtoCart() throws Exception {
	 priceV = driver.findElement(By.xpath("//li[3]/div//div[@class='right-block']//span[contains(@class,'product-price')]")).getText();
	System.out.println(priceV);
	Actions a = new Actions(driver);
	WebElement se = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[3]/div"));
	a.moveToElement(se).perform();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@title='Add to cart' and @data-id-product='3']/span")).click();
	
}

 @Test(priority = 3)
public  static void proceedToCheckout() throws Exception {
	 Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
	List<WebElement> li = driver.findElements(By.xpath("//table[@id='cart_summary']/tfoot/tr"));
List<WebElement> lid = li.get(0).findElements(By.tagName("td"));
	  proceedValue = lid.get(2).getText();
	System.out.println(proceedValue);
	
}
@Test(priority = 4)
public void valueCheck() {
	if (priceV.contentEquals(proceedValue)) {
		Assert.assertTrue("Price Values are equal", true);
	}
	
}
 
@Test(priority = 5)
public void tear() {
driver.quit();
}

}
