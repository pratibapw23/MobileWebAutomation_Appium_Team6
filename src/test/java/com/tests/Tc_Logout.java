package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Tc_Logout {
	static WebDriver driver;
  @Test
  public void verify_logout() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys("ankita");
		driver.findElement(By.name("password")).sendKeys("Pass9Test");
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[3]/div/button")).submit();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(350,0)", "");
		driver.findElement(By.xpath("//*[@id=\"nav-toggle\"]/i")).click();
	 
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"nav-menu\"]/ul/li[3]/a")).click();
	    Thread.sleep(2000);
	    String s=driver.findElement(By.xpath("/html/body/div[1]/div/div/form/span")).getText();
	
        Assert.assertEquals("Welcome",s);
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  driver= StartChrome.setCapabilitiesforAndroid();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
