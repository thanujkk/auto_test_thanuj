package com.logility.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class CreateOpenMailBoxAccount {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://app.openmailbox.org/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		SoftAssert sassert=new SoftAssert();
				
		driver.findElement(By.xpath("//div[@id='data']/div/button")).click();
		
		driver.findElement(By.id("register_id")).sendKeys("thanujkk03.com");//you have to change the username while running script every time
		driver.findElement(By.id("register_pw")).sendKeys("password123");
		driver.findElement(By.id("register_vpw")).sendKeys("password123");
		
		driver.findElement(By.xpath("//button[@id='register']")).click();
		
		//automating the captcha random captcha images are not possible through selenium webdriver
		//You have to click the captcha image manually
		//while clicking on captcha images manually, it is continuously showing the images and making registration failure
		//Hence this script on creating new account is not possible on this application using selenium webdriver
		
		Boolean statusDisplayed = driver.findElement(By.xpath("//a[@id='logout']/i")).isDisplayed();
		System.out.println("The logout button is displayed - "+statusDisplayed);
		Boolean statusEnabled = driver.findElement(By.xpath("//a[@id='logout']/i")).isEnabled();
		System.out.println("The logout button is enabled - "+statusEnabled);
		
		String expected="Choose your plan";
		String actual=driver.findElement(By.xpath("//div[@id='offers']//h2[contains(text(),'Choose your plan')]")).getText();
				
		sassert.assertEquals(actual, expected, "Choose your plan text is not present");
		System.out.println("Choose your plan text is present");
		System.out.println("Account Creation is successful");
		
		
		sassert.assertAll();
		
		driver.quit();
		
		
	}

}
