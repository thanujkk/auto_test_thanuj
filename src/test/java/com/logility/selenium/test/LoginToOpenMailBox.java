package com.logility.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginToOpenMailBox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://app.openmailbox.org/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys("thanujkk01");//existing username
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password123");
		
//		driver.findElement(By.xpath("(//div[@id='modal1']//div[@id='contener-button']//button[contains(text(),'Login')]")).click();
//		WebElement element = driver.findElement(By.xpath("(//button[contains(text(),'Login')])[2]"));
//		String elementText = driver.findElement(By.xpath("(//button[contains(text(),'Login')])[2]")).getText();
		
		WebElement element = driver.findElement(By.xpath("(//*[@id='login'])[1]"));
		String elementText = driver.findElement(By.xpath("(//*[@id='login'])[1]")).getText();
		
		
		Thread.sleep(5000);
		
//		Boolean statusEnabled = driver.findElement(By.xpath("(//button[contains(text(),'Login')])[2]")).isEnabled();
//		System.out.println("The login button is enabled - "+statusEnabled);
		
//		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[2]")).click();
		
		driver.findElement(By.xpath("(//*[@id='login'])[1]")).click();
		
		String expected1="Inbox";
		Thread.sleep(10000);
		String actual1=driver.findElement(By.xpath("//div[@id='titleHead']/b")).getText();
		System.out.println("Actual1 text is : "+actual1);		
		
		Assert.assertEquals(actual1, expected1, "Input link text is not present");
		System.out.println("Input link text is present");
		System.out.println("Login is successful");
		
		String expected2="Empty folder";
		String actual2=driver.findElement(By.xpath("//div[@id='list']//h1[contains(text(),'Empty')]")).getText();
		System.out.println("Actual2 text is : "+actual2);	
				
		Assert.assertEquals(actual2, expected2, "Empty folder text is not present");
		System.out.println("Empty folder text is present");
			
		
		driver.quit();
	}

}
