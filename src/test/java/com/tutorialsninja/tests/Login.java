package com.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Login {

	
	@Test()
	public void verifyLoginWithValidCredentials() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MUKUL JHA\\eclipse-workspace\\SeleniumTestNGProj\\src\\test\\resources\\chrd\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();	
		options.setBinary("D:\\Downloads 2023\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("mukuljha302@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Test@1234");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
	 //Assert.assertTrue(driver.findElement(By.xpath()).isDisplayed()  );
	 Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/ul[1]/li[1]/a")).isDisplayed()); 
	  driver.quit();
	
	}
	
	
	@Test()
	public void verifyLoginWithInvalidCredentials() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\MUKUL JHA\\eclipse-workspace\\SeleniumTestNGProj\\src\\test\\resources\\chrd\\chromedriver.exe" );
	ChromeOptions options=new ChromeOptions();
	options.setBinary("D:\\Downloads 2023\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Test@1234");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
		driver.quit();
		
	}
	
	
	public String generateEmailTimeStamp() {
		
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
	
	
	
	
}
