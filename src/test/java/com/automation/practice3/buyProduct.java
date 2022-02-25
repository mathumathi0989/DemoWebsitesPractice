package com.automation.practice3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class buyProduct {

	WebDriver driver = DriverSingleton.getDriver();
	public void mouseOver_Tshirts() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		Actions a = new Actions (driver);
		WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
		a.moveToElement(women).build().perform();
		driver.findElement(By.xpath("(//a[@title='T-shirts'])[1]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		WebElement prod = driver.findElement(By.xpath("//ul[@class='product_list grid row']/li"));
		a.moveToElement(prod).build().perform();
	}
	
	//Test Case - Automate end-to-end "Buy Product" feature
	@Test
	public void buy() throws Exception {
		
		mouseOver_Tshirts();
		driver.findElement(By.xpath("//div[@class='button-container']/a[@title='View']/span")).click();
		driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a[2]//i")).click();
		WebElement se = driver.findElement(By.name("group_1"));
		Select s = new Select(se);
		s.selectByValue("3");
		driver.findElement(By.xpath("//li/a[@name='Blue']")).click();
		driver.findElement(By.xpath("//button[@name='Submit']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span")).click();
		driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']/span")).click();
		
		userReg c = new userReg();
		c.userReg1("thanya1add1@gmail.com");
		Thread.sleep(1000);
		
		c.userCreate();
		driver.findElement(By.xpath("//button[@name='processAddress']/span")).click();
		driver.findElement(By.xpath("//div[@class='checker']//input")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']/span")).click();
		driver.findElement(By.xpath("//p[@class='payment_module']/a[@class='cheque']")).click();
		driver.findElement(By.xpath("//button[@type='submit']/span[contains(text(),'I confirm my order')]")).click();
		Thread.sleep(2000);
		String confirmation = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
		
		if (confirmation.contentEquals("Your order on My Store is complete.")) {
			System.out.println("Ordered has been placed");
			Reporter.log(confirmation);
		}
		else {
			System.out.println("Order is incomplete");
			Reporter.log(confirmation + "message not showing");
		}
		
		String cart = driver.findElement(By.xpath("//div[@class='shopping_cart']//span[@class='ajax_cart_no_product']")).getText();
		if (cart.contains("empty")) {
			System.out.println("Nothing is in the cart and order has been placed successfully");
			Reporter.log(cart + "is in the cart");
		}
		else 
		{
			System.out.println("Order is still in the cart");
			Reporter.log(cart + "items is still in the cart");
		}
		
		driver.findElement(By.xpath("//a[@class='logout']")).click();
		driver.quit();
		
	}
	
	
	//Test Case - Verify that 'Add to Wishlist' only works after login
	@Test
	public void wishlist() throws Exception {
		mouseOver_Tshirts();
	driver.findElement(By.className("wishlist")).click();
	
	Thread.sleep(3000);
	String wish_message = driver.findElement(By.xpath("//div[@class='fancybox-skin']/div/div")).getText();
	
	if(wish_message.contentEquals("You must be logged in to manage your wishlist.")) {
		System.out.println("Wish list message is displayed as "+wish_message);
		Reporter.log(wish_message);
	}
	else {
		System.out.println("Wishlist message is not matching or incorrect");
		Reporter.log(wish_message +"Not displaying");
	}
	
	driver.quit();
	
	}
	
	//Test Case - Verify that Total Price is reflecting correctly if user changes quantity on 'Shopping Cart Summary' Page.
	@Test
	public void totalPriceVerify() throws Exception {
		mouseOver_Tshirts();
		driver.findElement(By.xpath("//div[@class='button-container']/a[@title='View']/span")).click();
		WebElement se = driver.findElement(By.name("group_1"));
		Select s = new Select(se);
		s.selectByValue("2");
		driver.findElement(By.xpath("//li/a[@name='Blue']")).click();
		driver.findElement(By.xpath("//button[@name='Submit']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span")).click();
		
		String before_Price = driver.findElement(By.xpath("//tbody/tr/td[@class='cart_total']/span")).getText();
		driver.findElement(By.xpath("//div[@class='cart_quantity_button clearfix']/a[@title='Add']/span")).click();
		Thread.sleep(2000);
		String after_Price = driver.findElement(By.xpath("//tbody/tr/td[@class='cart_total']/span")).getText();
		
		if (!(before_Price.contentEquals(after_Price))){
			System.out.println("Total price is changing and reflecting correct price");
			Reporter.log("Quantity is not increased and its price showed as "+before_Price);
			Reporter.log("Quantity is increased and its price showed as "+after_Price);
		}
		else {
			System.out.println("Quantity is not changed");
			Reporter.log("Quantity remains the same");
			
		}
		driver.quit();
		
		
	}
	
	
	
	
	
}
