package com.automation.practice4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.practice1.DriverSingleton;

public class brokenLinksVerifyTest {

	static WebDriver driver = DriverSingleton.getDriver();
	public static String linkg;
	@Test
	public static void links() {
		driver.get("https://phptravels.com/demo/");
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println(li.size());
		Reporter.log(li.size() +"No. of links");
		li.forEach(lit -> {
			System.out.println(lit.getText());
			String linkg = lit.getAttribute("href");
			brokenlinks(linkg);
		});
		driver.quit();
}

	public static void brokenlinks(String linkUrl){
	
	try {
		URL url = new URL(linkUrl);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setConnectTimeout(5000);
			http.connect();
			if(http.getResponseCode()>=400) {
				System.out.println(linkUrl+"-"+http.getResponseMessage()+"is a broken link");
				Reporter.log(linkUrl+"-"+http.getResponseMessage()+"is a broken link");
			}
			else
			{
				System.out.println(linkUrl +"-"+http.getResponseMessage());
				Reporter.log(linkUrl+"-"+http.getResponseMessage());
			} }
		catch (IOException e) {
			e.printStackTrace(); }
	
			}
	
}
	

	
	
	
	
	
	
	
	
	

