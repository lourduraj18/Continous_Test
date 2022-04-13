package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginApp_Test {
	 WebDriver driver;
	  @Test(priority=1)
	  public void testLogin() {
		  	 driver.findElement(By.linkText("Log in")).click();
			 driver.findElement(By.id("Email")).sendKeys("ajayronaldo23@gmail.com");
			 driver.findElement(By.id("Password")).sendKeys("Ajay@1999");
			 driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
			String text = driver.findElement(By.linkText("ajayronaldo23@gmail.com")).getText();
			Assert.assertEquals(text, "ajayronaldo23@gmail.com");
			 
	  }
	  
	  @Test(priority=2,dependsOnMethods = "testLogin",alwaysRun = true)
	  public void testLogout() throws InterruptedException {
		  
		  driver.findElement(By.linkText("Log out")).click();
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			driver.get("http://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
			
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
}
