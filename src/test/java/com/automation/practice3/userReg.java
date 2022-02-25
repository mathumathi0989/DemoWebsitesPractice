package com.automation.practice3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class userReg {

	WebDriver driver = DriverSingleton.getDriver();
	public String URL = "http://automationpractice.com/index.php";
	public String fName = "Mathumathi";
	public String lName = "Balakrishnan";
	
	public void userError(String alreadyEmail) throws Exception {
		driver.findElement(By.name("email_create")).sendKeys(alreadyEmail);
		driver.findElement(By.name("SubmitCreate")).click();
		Thread.sleep(1000);
		WebElement al = driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li"));
		if (al.isDisplayed()) {
			driver.findElement(By.name("email_create")).clear();
			String als = driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li")).getText();
			System.out.println("Error message is " +als); }
	}

	public void userReg1(String emailID) throws Exception {
		driver.findElement(By.name("email_create")).sendKeys(emailID);
		driver.findElement(By.name("SubmitCreate")).click();
		Thread.sleep(5000);
	}
	
	public void userCreate() throws Exception {
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys(fName);
		driver.findElement(By.id("customer_lastname")).sendKeys(lName);
		driver.findElement(By.name("passwd")).sendKeys("12345");
		WebElement days = driver.findElement(By.name("days"));
		Select sdays = new Select(days);
		sdays.selectByValue("9");
		WebElement months = driver.findElement(By.name("months"));
		Select smonths = new Select(months);
		smonths.selectByValue("9");
		WebElement years = driver.findElement(By.name("years"));
		Select syears = new Select(years);
		syears.selectByValue("1989");
		driver.findElement(By.name("address1")).sendKeys("Jerseycity");
		driver.findElement(By.name("city")).sendKeys("Jerseycity");
		WebElement id_state = driver.findElement(By.name("id_state"));
		Select sState = new Select(id_state);
		sState.selectByValue("30");
		driver.findElement(By.name("postcode")).sendKeys("01341");
		driver.findElement(By.name("phone_mobile")).sendKeys("2013132412");
		driver.findElement(By.name("alias")).clear();
		driver.findElement(By.name("alias")).sendKeys("Mathu");
		driver.findElement(By.xpath("//button[@name='submitAccount']/span")).click();		
	}

	
	@BeforeMethod
	public void driverLaunch() {
		driver.get(URL);
		driver.findElement(By.className("login")).click();
	}
	
	//Verify invalid email address error.
	@Test (priority = 1)
	public void inValid() throws Exception {
		userError("aasd.com");
	}
	
	//Verify already registered email
	@Test (priority = 2)
	public void alreadyExists() throws Exception {
		userError("m11@gmail.com");
	}
	

	@Test (priority = 3)
	//Verify error messages for mandatory fields
	public void mandatory() throws Exception {
		userReg1("thanya1223@gmail.com");
		driver.findElement(By.xpath("//button[@name='submitAccount']/span")).click();
		String err = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
		System.out.println("*************************");
		System.out.println(err);
	}
	

	//Verify error messages for entering incorrect values in fields
	@Test (priority = 4)
	public void incorrect() throws Exception {
		userReg1("thanya11522@gmail.com");
		driver.findElement(By.xpath("//button[@name='submitAccount']/span")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("23424234");
		driver.findElement(By.id("customer_lastname")).sendKeys("234234");
		driver.findElement(By.name("city")).sendKeys("24234324");
		driver.findElement(By.name("postcode")).sendKeys("fafaf");
		driver.findElement(By.name("phone_mobile")).sendKeys("asfadasda");
		driver.findElement(By.xpath("//button[@name='submitAccount']/span")).click();
		String err = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
		System.out.println("*************************");
		System.out.println(err);
		System.out.println("*************************");
	}
	
	//Verify User Registration
	@Test (priority = 5)
	public void createUser() throws Exception {
		userReg1("thanya1832@gmail.com");
		userCreate();
		String ActualValue = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
		if (ActualValue.contains("Mathumathi Balakrishnan")) {
			System.out.println("User has been created and the user name is "+ActualValue);
		}
		driver.findElement(By.className("logout")).click();
		System.out.println("________________________________");
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
